package godot

import godot.annotation.Export
import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction
import godot.annotation.RegisterProperty
import godot.core.NodePath
import godot.core.Vector2
import godot.core.Vector2i
import godot.core.asCachedStringName
import godot.global.GD

@RegisterClass
class Main : Node() {

    @RegisterProperty
    var score = 0
    private var gameStarted = false

    // NOTE: Try to export to make it configurable in godot?
    private var cells = 20
    private var cellSize = 50

    @Export
    @RegisterProperty
    var snakeScene: PackedScene = PackedScene()

    private lateinit var oldData: MutableList<Vector2i>
    private lateinit var snakeData: MutableList<Vector2i>
    private lateinit var snake: MutableList<Panel>

    private var startPosition = Vector2i(9, 9)
    private var up = Vector2i(0, -1)
    private var down = Vector2i(0, 1)
    private var left = Vector2i(-1, 0)
    private var right = Vector2i(1, 0)
    private lateinit var moveDirection: Vector2i
    private var canMove = true

    private lateinit var food_position: Vector2i
    private var regenerateFood = true

    // called when the node enters the scene tree for the first time
    @RegisterFunction
    override fun _ready() {
        newGame()
    }

    private fun newGame() {
        getTree()!!.paused = false
        getTree()!!.callGroup("snake_segments".asCachedStringName(), "queue_free".asCachedStringName())
        (getNode(NodePath("GameOverMenu")) as CanvasLayer).hide()

        score = 0
        (getNode(NodePath("Hud/ScoreLabel")) as Label).text = "SCORE: $score"
        moveDirection = up
        canMove = true
        generateSnake()
        moveFood()
    }

    private fun generateSnake() {
        oldData = mutableListOf()
        snakeData = mutableListOf()
        snake = mutableListOf()

        for (i in 0..3) {
            addSegment(startPosition + Vector2i(0, i))
        }
    }

    private fun addSegment(pos: Vector2i) {
        snakeData.add(pos)
        val snakeSegment = snakeScene.instantiate() as Panel
        snakeSegment.setPosition(Vector2(pos.x * cellSize, pos.y * cellSize))
        addChild(snakeSegment)
        snake.add(snakeSegment)
    }


    // called every frame. 'delta' is the elapsed time since the previous frame
    @RegisterFunction
    override fun _process(delta: Double) {
        moveSnake()
    }

    private fun moveSnake() {
        if (canMove) {
            if (Input.isActionPressed("moveDown".asCachedStringName(), true) && moveDirection != up) {
                moveDirection = down
                canMove = false
                if (!gameStarted) startGame()
            }
            if (Input.isActionPressed("moveUp".asCachedStringName(), true) && moveDirection != down) {
                moveDirection = up
                canMove = false
                if (!gameStarted) startGame()
            }
            if (Input.isActionPressed("moveLeft".asCachedStringName(), true) && moveDirection != right) {
                moveDirection = left
                canMove = false
                if (!gameStarted) startGame()
            }
            if (Input.isActionPressed("moveRight".asCachedStringName(), true) && moveDirection != left) {
                moveDirection = right
                canMove = false
                if (!gameStarted) startGame()
            }
        }
    }

    private fun startGame() {
        gameStarted = true
        (getNode(NodePath("MoveTimer")) as Timer).start()
    }

    @RegisterFunction
    fun _onMoveTimerTimeout() {
        canMove = true
        oldData = snakeData.toMutableList()
        snakeData[0] += moveDirection
        checkOutOfBounds()

        for (i in 0 until snakeData.size) {
            if (i > 0) snakeData[i] = oldData[i - 1]
            // Drawing the snake
            snake[i].setPosition(Vector2(snakeData[i].x * cellSize, snakeData[i].y * cellSize))
        }

        checkSelfEaten()
        checkFoodEaten()
    }

    private fun checkOutOfBounds() {
        if (snakeData[0].x < 0 || snakeData[0].x > cells || snakeData[0].y < 1 || snakeData[0].y > cells + 1) {
            endGame()
        }
    }

    private fun checkSelfEaten() {
        for (i in 1 until snakeData.size) {
            // In case position of head is inside the body, i.e. any other element, then end game
            if (snakeData[0] == snakeData[i]) {
                endGame()
            }
        }
    }

    private fun moveFood() {
        // Make multiple foods?
        while (regenerateFood) {
            food_position = Vector2i((Math.random() * cells).toInt(), (Math.random() * cells).toInt() + 1)
            if (!snakeData.contains(food_position)) {
                regenerateFood = false
                (getNode(NodePath("Food")) as Sprite2D)
                    .setPosition(Vector2(food_position.x * cellSize, food_position.y * cellSize))
                break
            }
        }
    }

    private fun checkFoodEaten() {
        if (snakeData[0] == food_position) {
            addSegment(snakeData.last())
            score++
            (getNode(NodePath("Hud/ScoreLabel")) as Label).text = "SCORE: $score"
            regenerateFood = true
            moveFood()
        }
    }

    private fun endGame() {
        (getNode(NodePath("GameOverMenu/ResultLabel")) as Label).text = "SCORE: $score"
        (getNode(NodePath("GameOverMenu")) as CanvasLayer).show()
        (getNode(NodePath("MoveTimer")) as Timer).stop()
        gameStarted = false
        getTree()!!.paused = true
    }

    @RegisterFunction
    fun restartGame() {
        newGame()
    }
}
