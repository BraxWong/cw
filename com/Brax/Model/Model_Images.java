package com.Brax.Model;

import com.Brax.Controller.Controller_Image;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Model_Images {
    public static Map<String, Image> m_images = new HashMap<>();
   /**
    * Model_Images.put() will retrieve an image based on the string using HashMap functions
    */
    static
    {
        // snake
        m_images.put("snake-head-right", Controller_Image.GetImage("com/Brax/snakeModel/snake-head-right.png"));
        m_images.put("snake-head-right2", Controller_Image.GetImage("com/Brax/snakeModel/snake-head-right2.png"));
        m_images.put("snake-body", Controller_Image.GetImage("com/Brax/snakeModel/snake-body.png"));
        // obstacles
        m_images.put("0", Controller_Image.GetImage("com/Brax/foodPNG/food-kiwi.png"));
        m_images.put("1", Controller_Image.GetImage("com/Brax/foodPNG/food-lemon.png"));
        m_images.put("2", Controller_Image.GetImage("com/Brax/foodPNG/food-litchi.png"));
        m_images.put("3", Controller_Image.GetImage("com/Brax/foodPNG/food-mango.png"));
        m_images.put("4", Controller_Image.GetImage("com/Brax/foodPNG/food-apple.png"));
        m_images.put("5", Controller_Image.GetImage("com/Brax/foodPNG/food-banana.png"));
        m_images.put("6", Controller_Image.GetImage("com/Brax/foodPNG/food-blueberry.png"));
        m_images.put("7", Controller_Image.GetImage("com/Brax/foodPNG/food-cherry.png"));
        m_images.put("8", Controller_Image.GetImage("com/Brax/foodPNG/food-durian.png"));
        m_images.put("9", Controller_Image.GetImage("com/Brax/foodPNG/food-grape.png"));
        m_images.put("10", Controller_Image.GetImage("com/Brax/foodPNG/food-grapefruit.png"));
        m_images.put("11", Controller_Image.GetImage("com/Brax/foodPNG/food-peach.png"));
        m_images.put("12", Controller_Image.GetImage("com/Brax/foodPNG/food-pear.png"));
        m_images.put("13", Controller_Image.GetImage("com/Brax/foodPNG/food-orange.png"));
        m_images.put("14", Controller_Image.GetImage("com/Brax/foodPNG/food-pineapple.png"));
        m_images.put("15", Controller_Image.GetImage("com/Brax/foodPNG/food-strawberry.png"));
        m_images.put("16", Controller_Image.GetImage("com/Brax/foodPNG/food-watermelon.png"));
        m_images.put("UI-background", Controller_Image.GetImage("com/Brax/backgroundPNG/UI-background.png"));
        m_images.put("UI-background2",Controller_Image.GetImage("com/Brax/backgroundPNG/UI-background2.png"));
        m_images.put("UI-background3",Controller_Image.GetImage("com/Brax/backgroundPNG/UI-background3.jpg"));
        m_images.put("game-scene-01", Controller_Image.GetImage("com/Brax/misc/game-scene-01.jpg"));
        m_images.put("Fence",Controller_Image.GetImage("com/Brax/misc/Fence_Up.png"));
        m_images.put("Fence_Right", Controller_Image.GetImage("com/Brax/misc/Fence_Right.png"));
        m_images.put("Fence_Left", Controller_Image.GetImage("com/Brax/misc/Fence_Left.png"));
    }
}
