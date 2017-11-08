package com.mygdx.game.Scenes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Screens.PlayScreen;
import com.sun.prism.image.ViewPort;

/**
 * Created by Shailendra on 7/1/2017.
 */

public class Hud {

    public Label levelLabel;
    public Label timeLabel;
    public Label scoreLabel;
    public Label worldLabel;
    public Label marioLabel;
    public Label countdownLabel;
   public Stage stage;

    public Viewport viewPort;

public Hud(SpriteBatch sb)
{

    viewPort= new FitViewport(PlayScreen.vWidth,PlayScreen.vHeight,new OrthographicCamera());
    stage= new Stage(viewPort,sb);

    Table table= new Table();
     table.top();
    table.setFillParent(true);

            levelLabel= new Label("1-1", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
            timeLabel= new Label("TIME", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
            scoreLabel= new Label(String.format("%6d",00), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
            worldLabel= new Label("World", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
            marioLabel= new Label("MARIO", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
            countdownLabel= new Label(String.format("%3d",000000), new Label.LabelStyle(new BitmapFont(), Color.WHITE));

table.add(marioLabel).expandX().pad(2);
table.add(worldLabel).expandX().pad(2);
table.add(timeLabel).expandX().pad(2);
table.row();
    table.add(scoreLabel).expandX();
table.add(levelLabel).expandX();
table.add(countdownLabel).expandX();


stage.addActor(table);

}


  public void draw()
  {
      stage.draw();

  }

}
