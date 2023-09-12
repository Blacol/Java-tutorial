package com.blacol.zoo.entity;

public sealed class Animal permits Dog,Cat,Fox {
    public void call(){
        System.out.println("还不知道这个动物怎么叫");
    }
}
