## Contents

* [Code Retreat: The Problem](#problem)
* [Tips](#tips)
* [Common Game of Life Patterns](#patterns)
  * [Still Lifes](#stills)
  * [Oscillators](#oscillators)
  * [Space Ships](#spaceships)
  * [Methuselahs](#methuselahs)
  * [Miscellaneous](#misc)


## <a name="problem" />Code Retreat: The Problem

In a code retreat, we work on a single problem: [Conway's Game of Life](https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life)

(TBD)

## <a name="tips" />Tips

A code retreat round is typically 45 minutes long, after which you might have a short debriefing of 5 to 10 minutes, then a short break to switch partners before you start another round.

Forty-five minutes can go by pretty fast so you should try to make the most of what little time you have. The last thing you want to do is spend the entire session trying to figure out how to set up an initial pattern on your Game of Life board. I have seen participants spend as much as thirty minutes just writing code to do this, leaving them practically no time to explore any other aspects of the problem. That's not much fun unless you really want to practice reading/parsing strings and iterating over arrays with nested for-loops.

To help you save some time, I have laid out some common patterns below that you can use to seed the initial generation of your board. These are all patterns taken from the Wikipedia entry for Conway's Game of Life. The Wikipedia entry has more detailed information about the different patterns listed below.

For some of the patterns, I have included all the generations in the pattern's period, the number of generations it goes through before it repeats itself.

## <a name="patterns" />Common GoL Patterns (from Wikipedia)

Dimensions shown beside each pattern's name indicate (*rows* &times; *columns*). These are minimum dimensions designed to make it easier to figure out the coordinates of live cells in the pattern. I recommend using larger board sizes for patterns that move or span many generations.

### <a name="stills" />Still lifes

These patterns are stable and will not change from one generation to the next as long as they don't come in contact with another pattern.

**Block** (4 &times; 4)
```
    ....
    .XX.
    .XX.
    ....
```
**Beehive** (5 &times; 6)
```
    ......
    ..XX..
    .X..X.
    ..XX..
    ......
```
**Loaf** (6 &times; 6)
```
    ......
    ..XX..
    .X..X.
    ..X.X.
    ...X..
    ......
```
**Boat** (5 &times; 5)
```
    .....
    .XX..
    .X.X.
    ..X..
    .....
```
**Tub** (5 &times; 5)
```
    .....
    ..X..
    .X.X.
    ..X..
    .....
```
### <a name="oscillators" />Oscillators

Oscillators are patterns that repeat after a number of generations. The "period" is the number of generations a pattern will go through before it repeats. The oscillators listed below have a period of 2, meaning they will repeat every two generations, assuming they don't come in contact with another pattern.

**Blinker** (5 &times; 5)
```
    Generation n:
    .....
    ..X..
    ..X..
    ..X..
    .....

    Generation n + 1:
    .....
    .....
    .XXX.
    .....
    .....

```
**Toad** (6 &times; 6)
```
    Generation n:
    ......
    ......
    ..XXX.
    .XXX..
    ......
    ......

    Generation n + 1:
    ......
    ...X..
    .X..X.
    .X..X.
    ..X...
    ......

```    
**Beacon** (6 &times; 6)
```
    Generation n:
    ......
    .XX...
    .XX...
    ...XX.
    ...XX.
    ......

    Generation n + 1:
    ......
    .XX...
    .X....
    ....X.
    ...XX.
    ......

```
### <a name="spaceships" />Spaceships

Spaceships are oscillators that move around. Both the spaceships below have a period of 4.

**Glider** (6 &times; 10)
```
    (moves down and to the right)

    Generation n:
    ..........
    ...X......
    ....X.....
    ..XXX.....
    ..........
    ..........

    Generation n + 1:
    ..........
    ..........
    ..X.X.....
    ...XX.....
    ...X......
    ..........

    Generation n + 2:
    ..........
    ..........
    ....X.....
    ..X.X.....
    ...XX.....
    ..........

    Generation n + 3:
    ..........
    ..........
    ...X......
    ....XX....
    ...XX.....
    ..........

    Generation n + 4:
    ..........
    ..........
    ....X.....
    .....X....
    ...XXX....
    ..........

```
**Lightweight Spaceship (LWSS)** (7 &times; 20)
```
    (moves horizontally to the right)

    Generation n:
    ....................
    ..X..X..............
    ......X.............
    ..X...X.............
    ...XXXX.............
    ....................
    ....................

    Generation n + 1:
    ....................
    ....................
    .....XX.............
    ...XX.XX............
    ...XXXX.............
    ....XX..............
    ....................

    Generation n + 2:
    ....................
    ....................
    ....XXXX............
    ...X...X............
    .......X............
    ...X..X.............
    ....................

    Generation n + 3:
    ....................
    .....XX.............
    ....XXXX............
    ....XX.XX...........
    ......XX............
    ....................
    ....................

    Generation n + 4:
    ....................
    ....X..X............
    ........X...........
    ....X...X...........
    .....XXXX...........
    ....................
    ....................
```

### <a name="methuselahs" />Methuselahs

Given enough room, these small patterns can grow and live on for many generations and can even go on indefinitely. They can produce gliders and various oscillators and still life patterns, too.

**The R-pentomino** (5 &times; 5)
```
    .....
    ..XX.
    .XX..
    ..X..
    .....
```
**Diehard** (5 &times; 10)
```
    ..........
    .......X..
    .XX.......
    ..X...XXX.
    ..........
```
**Acorn** (5 &times; 9)
```
    .........
    ..X......
    ....X....
    .XX..XXX.
    .........
```    

### <a name="misc" />Miscellaneous

**Gosper Glider Gun** (11 &times; 38)
```
    ......................................
    .........................X............
    .......................X.X............
    .............XX......XX............XX.
    ............X...X....XX............XX.
    .XX........X.....X...XX...............
    .XX........X...X.XX....X.X............
    ...........X.....X.......X............
    ............X...X.....................
    .............XX.......................
    ......................................
```
**Flat Gun** (3 &times; 41)
```
    .........................................
    .XXXXXXXX.XXXXX...XXX......XXXXXXX.XXXXX.
    .........................................
```
