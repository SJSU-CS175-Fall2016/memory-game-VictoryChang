package com.example.victorychang.memorygame;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.LinkedList;
import java.util.Collections;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.TextView;
import android.widget.Button;
import android.widget.GridLayout;

public class GameActivity extends AppCompatActivity {

    // Maintain a list of images, shuffled every new game
    private LinkedList<Integer> shuffledImageList;

    // Maintain currentBoardState;
    //private LinkedList<Integer> currentBoardState;

    // Maintain elements on the board that are active
    private ImageButton imageButton1;   // Shown button 1
    private int imageButtonImageId1;    // Shown button 1's image Id
    private ImageButton imageButton2;   // Shown button 2
    private int imageButtonImageId2;    // Shown button 2's image Id
    private int shownCards = 0;             // Number of shown cards [0-2]
    private int points = 0;             // Number of points the user accumulated [0-10]
    private Button nomatchButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);


        // Checking savedInstanceState whether it be a new game or if a game is already started
        /*
        if (savedInstanceState != null) {

            shuffledImageList = (LinkedList<Integer>) savedInstanceState.getSerializable("shuffledImageList");

            if (savedInstanceState.containsKey("imageButton1Id")) {
                imageButton1 = (ImageButton) findViewById(savedInstanceState.getInt("imageButtonId1"));   // Shown button 1
                imageButtonImageId1 = savedInstanceState.getInt("imageButtonImageId1");    // Shown button 1's image Id
            }
            if (savedInstanceState.containsKey("imageButton2Id")) {
                imageButton2 = (ImageButton) findViewById(savedInstanceState.getInt("imageButtonId2"));
                imageButtonImageId2 = savedInstanceState.getInt("imageButtonImageId2");    // Shown button 2's image Id
            }

            shownCards = savedInstanceState.getInt("shownCards");;             // Number of shown cards [0-2]
            points = savedInstanceState.getInt("points");

            LinkedList<Integer> currentBoardState = (LinkedList<Integer>) savedInstanceState.getSerializable("currentBoardState");
            System.out.println("onCreate gotten getBoardState: " + currentBoardState);
            //setBoardState(currentBoardState);

            int nomatchButtonVisibility = savedInstanceState.getInt("nomatchButtonVisibility");
            nomatchButton = (Button) findViewById(R.id.nomatchButton);

            System.out.println("visibilty value: " + nomatchButtonVisibility);

            if (nomatchButtonVisibility == 0) {
                nomatchButton.setVisibility(View.VISIBLE);
            } else {
                nomatchButton.setVisibility(View.INVISIBLE);
            }



            System.out.println("Value or savedInstanceState: " + savedInstanceState);
        }
        */

       // Load the list of images (10x2) into shuffledImageList
       importImageIds();
       // Shuffle the list of images
       shuffleImageIds();





    }

    /**
     * Loads the list of pairs of image0-image9 from drawable into the shuffledImageList
     * Post Condition: shuffledImageList is initialized with 20 images
     */
    public void importImageIds() {

        GridLayout gl = (GridLayout) findViewById(R.id.gameGrid);

        for (int i=0; i< gl.getChildCount(); i++) {
            ImageButton ib = (ImageButton) gl.getChildAt(i);
            ib.setTag(R.drawable.cardback);
        }

        // Set a No Match button to visible and clickable
        nomatchButton = (Button) findViewById(R.id.nomatchButton);
        nomatchButton.setEnabled(false);
        nomatchButton.setVisibility(View.INVISIBLE);


        // Build default list of images to accept
        shuffledImageList = new LinkedList<Integer>();

        shuffledImageList.add(R.drawable.image0);
        shuffledImageList.add(R.drawable.image0);
        shuffledImageList.add(R.drawable.image1);
        shuffledImageList.add(R.drawable.image1);
        shuffledImageList.add(R.drawable.image2);
        shuffledImageList.add(R.drawable.image2);
        shuffledImageList.add(R.drawable.image3);
        shuffledImageList.add(R.drawable.image3);
        shuffledImageList.add(R.drawable.image4);
        shuffledImageList.add(R.drawable.image4);
        shuffledImageList.add(R.drawable.image5);
        shuffledImageList.add(R.drawable.image5);
        shuffledImageList.add(R.drawable.image6);
        shuffledImageList.add(R.drawable.image6);
        shuffledImageList.add(R.drawable.image7);
        shuffledImageList.add(R.drawable.image7);
        shuffledImageList.add(R.drawable.image8);
        shuffledImageList.add(R.drawable.image8);
        shuffledImageList.add(R.drawable.image9);
        shuffledImageList.add(R.drawable.image9);

        //System.out.println("Initial list of shuffledImageIds: " + shuffledImageList);
    }

    /**
     * Shuffles the list of images in the shuffledImageList
     * Post Condition: Image ids in shuffledImageList are shuffled
     */
    public void shuffleImageIds() {
        Collections.shuffle(shuffledImageList);
        System.out.println("New list of shuffledImageIds: " + shuffledImageList);
    }

    /* Used to save state
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        // Save properties that are needed to maintain the current state of the game.
        savedInstanceState.putSerializable("shuffledImageList", shuffledImageList);

        if (imageButton1 != null) {
            savedInstanceState.putInt("imageButtonId1", imageButton1.getId());
            savedInstanceState.putInt("imageButtonImageId1", imageButtonImageId1);
        }

        if (imageButton2 != null) {
            savedInstanceState.putInt("imageButtonId2", imageButton2.getId());
            savedInstanceState.putInt("imageButtonImageId2", imageButtonImageId2);
        }

        savedInstanceState.putInt("shownCards", shownCards);
        savedInstanceState.putInt("points", points);

        savedInstanceState.putSerializable("currentBoardState", getBoardState());

        savedInstanceState.putInt("nomatchButtonVisibility", nomatchButton.getVisibility());
    }
    */

    /**
     * Action to take when the user clicks on a valid memory game card.
     * @param view
     */
    public void imageButtonClickAction(View view) {
        // Pull an identifier suggesting which ImageButton was clicked
        System.out.println("Current View Id: " + view.getId());

        // Get the associated element number (used to to gather appropriate image in LinkedList)
        int position = -1;
        switch (view.getId()) {
            case R.id.button00:
                position = 0;
                break;
            case R.id.button01:
                position = 1;
                break;
            case R.id.button02:
                position = 2;
                break;
            case R.id.button03:
                position = 3;
                break;
            case R.id.button10:
                position = 4;
                break;
            case R.id.button11:
                position = 5;
                break;
            case R.id.button12:
                position = 6;
                break;
            case R.id.button13:
                position = 7;
                break;
            case R.id.button20:
                position = 8;
                break;
            case R.id.button21:
                position = 9;
                break;
            case R.id.button22:
                position = 10;
                break;
            case R.id.button23:
                position = 11;
                break;
            case R.id.button30:
                position = 12;
                break;
            case R.id.button31:
                position = 13;
                break;
            case R.id.button32:
                position = 14;
                break;
            case R.id.button33:
                position = 15;
                break;
            case R.id.button40:
                position = 16;
                break;
            case R.id.button41:
                position = 17;
                break;
            case R.id.button42:
                position = 18;
                break;
            case R.id.button43:
                position = 19;
                break;

            default:
                System.out.println("Using Invalid Button");
        }

        // Take an action depending on how many cards are currently active
        // If no cards are active, set the image and make the button unclickable
        if (shownCards == 0) {
            shownCards++;
            imageButton1 = (ImageButton) findViewById(view.getId());
            imageButtonImageId1 = shuffledImageList.get(position);
            imageButton1.setEnabled(false);
            imageButton1.setImageResource(imageButtonImageId1);
            imageButton1.setTag(imageButtonImageId1);
        }

        // If one card is active, take the appropriate action depending whether their image id's match or not.
        else if (shownCards == 1) {
            shownCards++;
            imageButton2 = (ImageButton) findViewById(view.getId());
            imageButtonImageId2 = shuffledImageList.get(position);
            imageButton2.setImageResource(imageButtonImageId2);
            imageButton2.setTag(imageButtonImageId2);

            // If both images match
            if (imageButtonImageId1 == imageButtonImageId2) {
                Toast.makeText(this, "Matched!", Toast.LENGTH_SHORT).show();

                // Change images to checkmarks
                imageButton1.setImageResource(R.drawable.check);
                imageButton1.setTag(R.drawable.check);
                imageButton2.setImageResource(R.drawable.check);
                imageButton2.setTag(R.drawable.check);

                imageButton1.setEnabled(false);
                imageButton2.setEnabled(false);

                TextView pointsTextView = (TextView) findViewById(R.id.pointsTextView);
                points++;
                pointsTextView.setText("Points: " + points);

                if (points == 10) {
                    Toast.makeText(this, "You Win the Game!", Toast.LENGTH_LONG).show();
                }

                shownCards=0;
            }
            // Otherwise, if there isn't a match
            else {
                //Toast.makeText(this, "No Match", Toast.LENGTH_SHORT).show();

                // Set a No Match button to visible and clickable
                Button nomatchButton = (Button) findViewById(R.id.nomatchButton);
                nomatchButton.setEnabled(true);
                nomatchButton.setVisibility(View.VISIBLE);
                imageButton1.setEnabled(true);

            }
        }

    }

    /**
     * Manages the button action to temporarily display and then reset an incorrect match
     * @param view
     */
    public void nomatchContinueClickAction(View view) {

        // make Invisible && disabled
        nomatchButton = (Button) findViewById(R.id.nomatchButton);
        nomatchButton.setVisibility(View.INVISIBLE);
        nomatchButton.setEnabled(false);

        // reset cardbacks
        if (imageButton1 != null) {
            imageButton1.setImageResource(R.drawable.cardback);
            imageButton1.setTag(R.drawable.cardback);
        }
        if (imageButton2 != null) {
            imageButton2.setImageResource(R.drawable.cardback);
            imageButton2.setTag(R.drawable.cardback);
        }
        shownCards = 0;
    }


    /* Used to save state
    public LinkedList<Integer> getBoardState() {
        LinkedList<Integer> currentBoardState = new LinkedList<Integer>();
        GridLayout gl = (GridLayout) findViewById(R.id.gameGrid);

        for (int i=0; i< gl.getChildCount(); i++) {
            ImageButton ib = (ImageButton) gl.getChildAt(i);
            currentBoardState.add((Integer)ib.getTag());
        }

        System.out.println("Manual getBoardState: " + currentBoardState);
        return currentBoardState;
    }
    */
    /* used to save state
    public void setBoardState(LinkedList<Integer> boardState) {
        System.out.println("Manual setBoardState: " + boardState);

        GridLayout gl = (GridLayout) findViewById(R.id.gameGrid);

        for (int i=0; i< gl.getChildCount(); i++) {
            ImageButton ib = (ImageButton) gl.getChildAt(i);
            ib.setImageResource(boardState.get(i));
            ib.setTag(boardState.get(i));
        }
    }
    */

}

