import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class PriorityQueueTest {
    static Stream<Arguments> stringIntAndListProvider() {
        return Stream.of(
            Arguments.of(new int[]{3,1,2}, new int[]{1,2,3}),
            Arguments.of(new int[]{-3,-1,-2,5}, new int[]{-3,-2,-1,5}),
            Arguments.of(new int[]{3,-2,-5,-1,2}, new int[]{-5,-2,-1,2,3}),
            Arguments.of(new int[]{-3,1,11,0,9,3}, new int[]{-3,0,1,3,9,1}),
            Arguments.of(new int[]{3,7,2,-1,-2}, new int[]{-2,-1,2,3,7})
        );
    }
    @ParameterizedTest(name="#{index} - Test with Argument={0},{1}")
    @MethodSource("stringIntAndListProvider")
    public void PriorityQueue_RunTest(int[] random_array, int[] correct_array){
        PriorityQueue<Integer> test = new PriorityQueue<Integer>();
        int index = 0;
        Integer s;
        int[] result = new int[random_array.length];

        //TODO random_array add to prorityQueue
        for ( int i = 0; i  <  random_array.length; i++ ){
            test.add(random_array[i]) ;
        }
        System.out.println ( "Initial priority queue values are: "+ test);
        //TODO get prorityQueue result.
        for ( int i = 0; i  <  correct_array.length; i++ ){
            result[i] = test.poll();
        }

        assertArrayEquals(correct_array, result);

    }
    @Test
    public void whenExceptionThrown_thenInitialCapacityNotGreaterThanOne(){
        assertThrows(IllegalArgumentException.class,()->{
            PriorityQueue<Integer> priorityqueue=new PriorityQueue<Integer>(-1,null);
        });
    }
    @Test
    public void whenExceptionThrown_thenOfferEisNull(){
        assertThrows(NullPointerException.class,()->{
            PriorityQueue<Integer>priorityqueue=new PriorityQueue<Integer>();
            priorityqueue.offer(null);
        });
    }
    @Test
    public void whenExceptionThrown_thenNoElementCanRemove(){
        assertThrows(NoSuchElementException.class,()->{
            PriorityQueue<Integer>priorityqueue=new PriorityQueue<Integer>();
            priorityqueue.remove();
        });
    }
}
