/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.nashorntest;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import java.util.HashMap;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import org.openjdk.nashorn.api.scripting.NashornScriptEngineFactory;

/**
 *
 */
@WebListener
public class NashornTester implements
        ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        try {
            NashornScriptEngineFactory fac = new NashornScriptEngineFactory();
            ScriptEngine e = fac.getScriptEngine(new String[0],
                    Thread.currentThread().getContextClassLoader());

            e.eval("function main() { return 'hello world'; }");
            String result = (String) ((Invocable)e).invokeFunction("main", new HashMap<>());
            System.out.println(result);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
