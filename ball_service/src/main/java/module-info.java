open module ball_service
{
   exports ball_service.api;
   requires transitive domain;

   requires java.logging;
   //requires lombok;
   requires spring.context;
   requires spring.boot.autoconfigure;
   requires spring.boot;
   requires spring.web;
   requires spring.beans;
}