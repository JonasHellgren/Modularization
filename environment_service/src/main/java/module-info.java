module environment_service
{
   exports environment_service.api;
   requires  domain;

   requires java.logging;
   //requires lombok;

   requires spring.context;
   requires spring.boot.autoconfigure;
   requires spring.boot;
   requires spring.web;
   requires spring.beans;

}