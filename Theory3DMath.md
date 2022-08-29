
# Theory of 3D math


## 2d coordinate transformation

![img_6.png](img_6.png)



    pv=[1,1];                           %point in camera UV system
    U=[1,-1]; V=[1,1];                  %U and V expressed in x and y
    Unorm=U/norm(U);   Vnorm=V/norm(V); %normalize to get length 1
    M=[Unorm;                           %create transformation matrix
       Vnorm];
    pw=M*pv';                           %transform from UV to xy

pw will be (0,1.41)

## View camera

The camera defines how the observer sees the world, i.e. the viewing angles and distance to the object(s).
Cartesian right-handed coordinate system is used, right in figure below.
![img_9.png](img_9.png)


The figure below defines the camera and its axles. Camera view (UVN) in real world (xyz).


![img_10.png](img_10.png)

*	U corresponds to display x-axis and V to display y-axis.
*	It is natural but not necessary to let N go in the opposite direction of r.
*	Point in camera view coordinates is pv.
*	Point in real world coordinates is pw.


![img_14.png](img_14.png)



### Examples:

![img_15.png](img_15.png)


##	World coordinate to camera coordinates

![img_16.png](img_16.png)

Perpendicular row vectors of M gives

![img_19.png](img_19.png)

### Examples:

![img_18.png](img_18.png)

# Projection

A vertex point pv is projected on the U and V axes at point pvp. The projected 2D position depends on the depth distance d. 
The alpha in the figure below is the zoom factors. The figure handles V projection.

![img_20.png](img_20.png)


![img_21.png](img_21.png)

gives

![img_23.png](img_23.png)


### Examples

![img_24.png](img_24.png)
