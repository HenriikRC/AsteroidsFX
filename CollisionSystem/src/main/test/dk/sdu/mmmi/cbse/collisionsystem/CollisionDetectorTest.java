package dk.sdu.mmmi.cbse.collisionsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CollisionDetectorTest {

    private CollisionDetector collisionDetector;

    @Before
    public void setUp() {
        collisionDetector = new CollisionDetector();
    }

    @Test
    public void TestEntitiesShouldNotCollide() {
        Entity ent1 = new Entity();
        ent1.setX(100);
        ent1.setY(100);
        ent1.setRadius(1);

        Entity ent2 = new Entity();
        ent2.setX(-100);
        ent2.setY(-100);
        ent2.setRadius(1);

        assertFalse(collisionDetector.collides(ent1, ent2));
    }

    @Test
    public void TestEntitiesShouldCollide() {
        Entity ent1 = new Entity();
        ent1.setX(50);
        ent1.setY(50);
        ent1.setRadius(100);

        Entity ent2 = new Entity();
        ent2.setX(-50);
        ent2.setY(-50);
        ent2.setRadius(100);

        assertTrue(collisionDetector.collides(ent1, ent2));
    }
}
