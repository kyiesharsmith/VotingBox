import stanford.karel.*;

public class VotingBox extends SuperKarel {

	public void run() {
		while (frontIsClear() ) {
			move() ; 
			if (noBeepersPresent() ) {
				removeChad() ;
			}
			move();
		}
		
				
	}
	
/**
 * Chads will be removed from a ballot which consists of beepers
 * in squares that are to the  right and left of Karel's current position
 */
	private void removeChad() {
		turnRight() ;
		checkPunchCorner() ;
		checkPunchCorner() ;
		turnLeft() ;
	}
	/**
	 * Chad's are removed from any corner that is in front of Karel. The 
	 * precondition is that Karel is currently facing one of the corners
	 * that represents a punched hole in the ballot; the postcondition
	 * is that Karel is on the same square and now facing in the opposite
	 * direction because it just came out of the hole.
	 */
	private void checkPunchCorner() {
		move() ; 
		while (beepersPresent()) {
			pickBeeper() ;
		}
		turnAround() ;
		move() ;
	}
}