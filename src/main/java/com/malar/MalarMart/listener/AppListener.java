package com.malar.MalarMart.listener;

import com.malar.MalarMart.util.DatabaseInitializer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        DatabaseInitializer.initialize();
        System.out.println("MalarMart application started.");
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        System.out.println("MalarMart application stopped.");
    }
}