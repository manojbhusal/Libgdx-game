package com.mygdx.game.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Controller;
import com.mygdx.game.MarioMan;
import com.mygdx.game.Scenes.Hud;
import com.mygdx.game.Sprites.Mario;
import com.sun.prism.image.ViewPort;

/**
 * Created by Shailendra on 7/1/2017.
 */

public class PlayScreen implements Screen {


    public MarioMan game;
    private OrthographicCamera gameCam;
    private Viewport gamePort;
    public static final int vWidth = 400;
    public static final int vHeight = 208;
    Hud hud;
    private TextureAtlas atlas;
    Controller controller;

    private TmxMapLoader mapLoader;
    private OrthogonalTiledMapRenderer renderer;
    private TiledMap map;
    World world;
    Box2DDebugRenderer b2dr;

    Mario mario;
    public PlayScreen(MarioMan game) {
        this.game = game;
   controller= new Controller(game.batch);
        gameCam = new OrthographicCamera();
        gamePort = new FitViewport(vWidth/MarioMan.ppm, vHeight/MarioMan.ppm, gameCam);
        hud = new Hud(game.batch);

        atlas= new TextureAtlas("Mario_and_Enemies.pack");


//
        mapLoader = new TmxMapLoader();
        map = mapLoader.load("Mytmxmap.tmx");
        renderer = new OrthogonalTiledMapRenderer(map,1/MarioMan.ppm);

        //added
        renderer.setView(gameCam);
         renderer.render();

//



        gameCam.position.set(gamePort.getWorldWidth() / 2, gamePort.getWorldHeight() / 2, 0);

        world = new World(new Vector2(0, -10), true);
        b2dr=new Box2DDebugRenderer();
    mario= new Mario(world,this);

        BodyDef bodyDef= new BodyDef();
        PolygonShape shape=new PolygonShape();

        FixtureDef fdef= new FixtureDef();
        Body body;



         for       (MapObject object: map.getLayers().get(2).getObjects().getByType(RectangleMapObject.class))
        {

            Rectangle rect=((RectangleMapObject)object).getRectangle();


                bodyDef.type=BodyDef.BodyType.StaticBody;
                bodyDef.position.set((rect.getX()+rect.getWidth()/2)/MarioMan.ppm,(rect.getY()+rect.getHeight()/2)/MarioMan.ppm);


            body=world.createBody(bodyDef);

            shape.setAsBox(rect.getWidth()/2/MarioMan.ppm,rect.getHeight()/2/MarioMan.ppm);
            fdef.shape=shape;
            body.createFixture(fdef);

        }


        //pipe 3

        for       (MapObject object: map.getLayers().get(3).getObjects().getByType(RectangleMapObject.class))
        {

            Rectangle rect=((RectangleMapObject)object).getRectangle();


            bodyDef.type=BodyDef.BodyType.StaticBody;
            bodyDef.position.set((rect.getX()+rect.getWidth()/2)/MarioMan.ppm,(rect.getY()+rect.getHeight()/2)/MarioMan.ppm);


            body=world.createBody(bodyDef);

            shape.setAsBox(rect.getWidth()/2/MarioMan.ppm,rect.getHeight()/2/MarioMan.ppm);
            fdef.shape=shape;
            body.createFixture(fdef);

        }


//bricks 5

        for       (MapObject object: map.getLayers().get(5).getObjects().getByType(RectangleMapObject.class))
        {

            Rectangle rect=((RectangleMapObject)object).getRectangle();


            bodyDef.type=BodyDef.BodyType.StaticBody;
            bodyDef.position.set((rect.getX()+rect.getWidth()/2)/MarioMan.ppm,(rect.getY()+rect.getHeight()/2)/MarioMan.ppm);


            body=world.createBody(bodyDef);

            shape.setAsBox(rect.getWidth()/2/MarioMan.ppm,rect.getHeight()/2/MarioMan.ppm);
            fdef.shape=shape;
            body.createFixture(fdef);

        }


//coin 4

        for       (MapObject object: map.getLayers().get(4).getObjects().getByType(RectangleMapObject.class))
        {

            Rectangle rect=((RectangleMapObject)object).getRectangle();


            bodyDef.type=BodyDef.BodyType.StaticBody;
            bodyDef.position.set((rect.getX()+rect.getWidth()/2)/MarioMan.ppm,(rect.getY()+rect.getHeight()/2)/MarioMan.ppm);


            body=world.createBody(bodyDef);

            shape.setAsBox(rect.getWidth()/2/MarioMan.ppm,rect.getHeight()/2/MarioMan.ppm);
            fdef.shape=shape;
            body.createFixture(fdef);

        }








    }




    public TextureAtlas getAtlas()
    {

        return atlas;

    }



    @Override
    public void show() {

    }


    public void handleInput(float dt) {

        if (controller.isUpPressed()&& mario.body.getLinearVelocity().y<=2) {

            mario.body.applyLinearImpulse(new Vector2(0,1f),mario.body.getWorldCenter(),true);

        }
  if (controller.isRightPressed() && mario.body.getLinearVelocity().x<=2) {

            mario.body.applyLinearImpulse(new Vector2(0.1f,0),mario.body.getWorldCenter(),true);

        }
        if (controller.isLeftPressed() && mario.body.getLinearVelocity().x>=-2) {

            mario.body.applyLinearImpulse(new Vector2(-0.1f,0),mario.body.getWorldCenter(),true);

        }












    }


    public void update(float dt) {

        handleInput(dt);


        world.step(1/60f,6,2);

        mario.update(dt);


    gameCam.position.x = mario.body.getPosition().x;



        gameCam.update();

        renderer.setView(gameCam);


    }


    @Override
    public void render(float delta) {

        update(delta);


    //    Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClearColor(135/255f, 206/255f, 235/255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        renderer.render();

controller.draw();
      hud.draw();

        b2dr.render(world,gameCam.combined);

        game.batch.setProjectionMatrix(gameCam.combined);
        game.batch.begin();
      //  hud.stage.draw();
        mario.draw(game.batch);
        game.batch.end();


    }

    @Override
    public void resize(int width, int height) {
        gamePort.update(800, 480);


    controller.resize(width,height);


    }


    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
