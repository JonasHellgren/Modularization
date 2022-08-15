Based on

    https://www.youtube.com/watch?v=8ZPxJZvJ9Gg&list=PLgcKMlJueAM62thU14ic5FWZ3Tv-C3tOI&index=107

Runner class in main module, package main, can only access package util module util.api.
Module util does not export package internal.

module-info-java file worked first then placed in root source folder (blue marked) and package keyword used in top 
of classes.

module-info-java file in main module
    
    module main
    {
    requires util;
    }


module-info-java file in util module

    module util
    {
    exports util.api;
    }