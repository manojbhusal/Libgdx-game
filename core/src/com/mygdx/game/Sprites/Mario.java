package com.mygdx.game.Sprites;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.Controller;
import com.mygdx.game.MarioMan;
import com.mygdx.game.Screens.PlayScreen;

/**
 * Created by Shailendra on 7/1/2017.
 */

public class Mario extends Sprite {
    public World world;
    public Body body;
    private TextureRegion marioStand;


public Mario(World world, PlayScreen screen)
{

      super(screen.getAtlas().findRegion("little_mario"));

    this.world= world;
    defineMario();
    marioStand= new TextureRegion(getTexture(), 0,10,16,16);
    setBounds(0,0,16/MarioMan.ppm,16/MarioMan.ppm);
    setRegion(marioStand);


}

    private void defineMario() {
        BodyDef bdef= new BodyDef();
        bdef.position.set(32/ MarioMan.ppm,32/ MarioMan.ppm);
        bdef.type= BodyDef.BodyType.DynamicBody;
        body=world.createBody(bdef);

        FixtureDef fdef= new FixtureDef();

        CircleShape shape= new CircleShape();
        shape.setRadius(6/ MarioMan.ppm);

        fdef.shape=shape;
        body.createFixture(fdef);













    }

public void update(float dt){


    setPosition(body.getPosition().x-getWidth()/2,body.getPosition().y-getHeight()/2);

}
}
