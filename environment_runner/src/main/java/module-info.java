open module environment_runner
{
   //exports ball_service.api;
  // requires  ball_service;

//    requires environment_service;


    requires spring.context;
    requires spring.boot.autoconfigure;
    requires spring.boot;
    requires spring.web;
    requires spring.beans;
    requires org.apache.tomcat.embed.core;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;

}