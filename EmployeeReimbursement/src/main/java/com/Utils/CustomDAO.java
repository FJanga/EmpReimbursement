package com.Utils;

public interface CustomDAO<T> {

//    CRUD = Create Read Update Delete
//    All basic functionality that can be done
//     when storing data

//   return an Integer here
//    and expect a param of type T

    Integer create(T t);


    //    return type os 'T'
//    and is expect a param of type Integer
    T read(Integer id);



    //    return type of 'T'
//    also expect a param of type T
    T update (T t);

    //return type is boolean
    boolean delete(Integer id);

}


