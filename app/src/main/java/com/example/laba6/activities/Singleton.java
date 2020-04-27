package com.example.laba6.activities;

//Класс Singleton нужен нам для того , чтобы передать наш массив данных из одного активити в другое

import com.example.laba6.Model;

import java.util.List;

public class Singleton {
    private static Singleton singleObject;
    private List<Model> items;

    public static Singleton getInstance()
    {
        if(singleObject == null)
        {
            singleObject = new Singleton();
        }
        return singleObject;
    }

    public void setItems(List<Model> items) {
        this.items = items;
    }

    public List<Model> getItems() {
        return items;
    }

    public Model getItem(int id)
    {
        for(int i = 0; i < items.size(); i++)
        {
            if(items.get(i).getName().equals(i)) {
                return items.get(i);
            }
        }
        return null;
    }
}
