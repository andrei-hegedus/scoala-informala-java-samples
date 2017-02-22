import java.util.Random;

/**
 * Created by andrei on 2/15/17.
 */
public class ClassGradeAverage {

    public static void main(String[] args) throws InterruptedException {
        // catalog is a shared resource
        float[] catalog = new float[15]; // 15 pupils in the class
        PupilThread [] threads = new PupilThread[15];
        for(int i = 0;i<15;i++){
            threads[i] = new PupilThread(i, catalog);
            threads[i].start();
            //threads[i].join();
        }
        for(PupilThread pt : threads){
            pt.join();
        }
        float yearEndGradeAvg = 0;
        for(float grade : catalog){
            yearEndGradeAvg+=grade;
        }
        yearEndGradeAvg/=15f;
        System.out.println("Year's End Grades Average: "+yearEndGradeAvg);
    }

    private static class PupilThread extends Thread {

        private int order;
        private float[] catalog;

        public PupilThread(int order, float[] catalog) {
            this.order = order;
            this.catalog = catalog;
        }

        @Override
        public void run() {
            Random r = new Random();
            float gradeAvg = 0;
            for(int i=0;i<10;i++){
                int grade = r.nextInt(10);
                gradeAvg+=grade;
            }
            gradeAvg/=10f;
            catalog[order]=gradeAvg;
            System.out.println("Pupil "+order+" grade is: "+gradeAvg);
        }
    }
}
