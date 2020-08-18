### Koyo loans Backend Programming Test

#### Problem Definition

You have been asked to write the “model/business rules” component of a larger program which allows two human players to play chess.  As such, there is no need to worry about any aspects of the user interface. 
You can complete this task in either Java or Kotlin.  There should not be a need to use any 3rd party libraries apart from a testing framework.
Spend an absolute maximum of 4 hours on this task.

#### Step 1.

Model and create a board object containing pieces owned by one of two players.  Initialize the board with the default Chess starting position.   See  https://en.wikipedia.org/wiki/Rules_of_chess#Initial_setup

#### Step 2.

Allow a piece to be moved from one position to another.  Validate that the piece being moved is owned by the correct player.  At this stage, do not further validate that the piece is being moved correctly.  

#### Step 3.

Modify the program to check that the bishop and pawns move according to the rules of chess (see https://en.wikipedia.org/wiki/Rules_of_chess#Basic_moves).
Do not worry about more advanced moves (e.g. castling, pawn promotion, “en passant” etc) or special cases (such as the player being in check/checkmate).
Submission

Upload the completed code to ... (zip/tarball/git bundle).  Do not leave the code on a publicly accessible website such as github.

#### Assessment Criteria

We will be looking at a number of factors including :-
 - Correctness – does it run, does it correctly implement the rules? 
 - Overall design – how clean is the design, how easier is it to maintain?
 - Code readability - is the code readable, does it make appropriate use of langauge constructs?
 - Tests – are there tests at the appropriate level, how complete are they, how easy are they to understand and maintain?
 - Documentation – appropriate level of comments and other documention
