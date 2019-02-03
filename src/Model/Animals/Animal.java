package Model.Animals;

import Model.Cell;
import Model.Ground;
import View.SpriteAnimation.SpriteAnimation;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.Random;


public abstract class Animal {
    protected Group mainRoot;
    protected int row;
    protected int column;
    protected int cost;
    protected String ID;
    protected String name;
    protected Image up;
    protected ImageView upView;
    protected Image down;
    protected ImageView downView;
    protected Image left;
    protected ImageView leftView;
    protected Image right;
    protected ImageView rightView;
    protected Image downRight;
    protected ImageView downRightView;
    protected Image upRight;
    protected  ImageView upRightView;
    protected  Image upLeft;
    protected ImageView upLeftView;
    protected Image downLeft;
    protected ImageView downLeftView;
    protected Image caged;
    protected ImageView cagedView;
    protected Image eat;
    protected ImageView eatView;
    protected Image death;
    protected ImageView deathView;


    public Animal(int x, int y, String ID , Group mainRoot) {
        Random r = new Random();
        this.row = r.nextInt(y);
        this.column = r.nextInt(x);
        this.ID = ID;
        this.mainRoot = mainRoot;
    }

    public int direction(Ground ground) {
        Random random = new Random();
        return random.nextInt(4) + 1;
    }


    public void checkTime(Ground ground) throws Exception {
        move(this.direction(ground), ground);
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
    public abstract void moveRight(Ground ground);
    public abstract void moveLeft(Ground ground);
    public abstract void moveDown(Ground ground);
    public abstract  void moveUp(Ground ground);
    public abstract void caged(Ground ground);
    public abstract void eat(Ground ground);
    public void show(ImageView imageView, int width, int height , Ground ground , int direction , int rows , int colmuns) {
        int x1 = ground.getCells()[this.row][this.column].getWidth();
        int y1 =ground.getCells()[this.row][this.column].getHeight();

        mainRoot.getChildren().add(imageView);
        imageView.relocate(x1, y1);
        final SpriteAnimation[] spriteAnimation = {new SpriteAnimation(imageView, Duration.millis(500), rows*colmuns,
                colmuns, 0, 0, width, height)};
        spriteAnimation[0].setCycleCount(3);
        spriteAnimation[0].play();
        AnimationTimer animationTimer = new AnimationTimer() {
            int i = 0;
            @Override
            public void handle(long now) {
                if(direction ==1) {//right
                    if (i < 26) {
                        spriteAnimation[0].setCycleCount(Animation.INDEFINITE);
                        spriteAnimation[0].play();
                        imageView.relocate((x1 + i), (y1));
                    } else {
                        spriteAnimation[0].stop();
                        mainRoot.getChildren().remove(imageView);
                       this.stop();
                    }

                }else if (direction == 3){ //left
                    if (i < 26) {
                        spriteAnimation[0].setCycleCount(Animation.INDEFINITE);
                        spriteAnimation[0].play();
                        imageView.relocate((x1 - i), (y1));
                    } else {
                        spriteAnimation[0].stop();
                        mainRoot.getChildren().remove(imageView);
                        this.stop();
                    }

                }else if(direction == 2){//up
                    if (i < 20) {
                        spriteAnimation[0].setCycleCount(Animation.INDEFINITE);
                        spriteAnimation[0].play();
                        imageView.relocate((x1 - i), (y1));
                    } else {
                        spriteAnimation[0].stop();
                        this.stop();
                    }

                }else if(direction == 4){//down
                    if (i < 20) {
                        spriteAnimation[0].setCycleCount(Animation.INDEFINITE);
                        spriteAnimation[0].play();
                        imageView.relocate((x1 + i), (y1));
                    } else {
                        spriteAnimation[0].stop();
                        mainRoot.getChildren().remove(imageView);
                        this.stop();
                    }

                }
                else if(direction ==5 || direction == 6){//death or eat
                    if (i < 20) {
                        spriteAnimation[0].setCycleCount(Animation.INDEFINITE);
                        spriteAnimation[0].play();
                        imageView.relocate((x1 ), (y1));
                    } else {
                        spriteAnimation[0].stop();
                        mainRoot.getChildren().remove(imageView);
                       this.stop();
                    }


                }
                i++;
            }
        };
        animationTimer.start();
    }

    public void move(int  direction, Ground ground) throws Exception {
        switch (direction) {
            case 1:   // 1 ---->>  right
                if ( this.column >= ground.getNumberOfColumns()-1 ) {
                    move(3, ground);
                }else {
                    this.makeChangesOnCell(ground.getCells()[this.row ][this.column ], -1);
                    this.column++;
                    this.makeChangesOnCell(ground.getCells()[this.row ][this.column ], 1);
                    this.moveRight(ground);
                }
                break;
            case 2:   // 2 ---->>   up
                if ( this.row <= 0 ) {
                    move(4, ground);
                }else {
                    this.makeChangesOnCell(ground.getCells()[this.row ][this.getColumn() ], -1);
                    this.row--;
                    this.makeChangesOnCell(ground.getCells()[this.row ][this.getColumn() ], 1);
                    moveUp(ground);
                }
                break;
            case 3:   // 3  ---->>   left
                if ( this.column <= 0) {
                    move( 1, ground);
                } else {
                    this.makeChangesOnCell(ground.getCells()[this.row ][this.getColumn() ], -1);
                    this.column--;
                    this.makeChangesOnCell(ground.getCells()[this.row ][this.getColumn()], 1);
                    moveLeft(ground);
                }
                break;
            case 4:   //  4  ---->>   down
                if (this.row >= ground.getNumberOfRows() -1) {
                    move(2, ground);
                } else {
                    this.makeChangesOnCell(ground.getCells()[this.row ][this.getColumn() ], -1);
                    this.row++;
                    this.makeChangesOnCell(ground.getCells()[this.row ][this.getColumn() ], 1);
                    moveDown(ground);
                }
                break;
        }
    }

    public abstract void makeChangesOnCell(Cell cell, int a);


    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}