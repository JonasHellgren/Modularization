
The intention with this project is to show the interaction between two services implemented in spring boot: 
1. BallRunnerApplication
2. ViewApplication

Another objective is to apply the java modular system. There are four modules:
1. ball_runner (includes BallRunnerApplication)
2. ball_service
3. ball_viewer (includes ViewApplication)
4. domain

Running BallRunnerApplication and ViewApplication will start up a frame with a bouncing ball.

ViewApplication consumes REST data exposed in BallController, included in ball_runner.

Reading URL according to
https://www.baeldung.com/rest-template

![img.png](img.png)