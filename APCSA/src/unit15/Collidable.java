package unit15;

public interface Collidable {
	boolean didCollideLeft(Object obj);

	boolean didCollideRight(Object obj);

	boolean didCollideTop(Object obj);

	boolean didCollideBottom(Object obj);
}