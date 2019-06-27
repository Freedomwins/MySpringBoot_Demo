package com.qf.service;

import com.qf.entity.Classes;

import java.util.List;

public interface IClassesService {
    public Classes getClassesById(int id);
    public List<Classes> queryAll();
}
