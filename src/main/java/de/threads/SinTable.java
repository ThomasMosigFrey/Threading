package de.threads;


public class SinTable extends GuidedLoopHandler {
    public float sumValues[];
    private float lookupValues[];

    public SinTable() {
        super(0, 360 * 100, 100, 12);
        lookupValues = new float[360 * 100];
        sumValues = new float[360 * 100];
    }

    public static void main(String args[]) {
        System.out.println("Starting Example 7 (Shared Variable Example)");

        SinTable st = new SinTable();
        float results[] = st.getValues();

        System.out.println("Results: " + results[0] + ", " +
                results[1] + ", " + results[2] + ", " + "...");
        System.out.println("Sums: " + st.sumValues[0] + ", " +
                st.sumValues[1] + ", " + st.sumValues[2] + ", " + "...");
        System.out.println("Done");
    }

    public void loopDoRange(int start, int end) {
        float sinValue = 0.0f;
        for (int i = start; i < end; i++) {
            sinValue = (float) Math.sin((i % 360) * Math.PI / 180.0);
            lookupValues[i] = sinValue * (float) i / 180.0f;
        }
    }

    public float[] getValues() {
        loopProcess();
        sumValues[0] = lookupValues[0];
        for (int i = 1; i < (360 * 100); i++) {
            sumValues[i] = lookupValues[i] + lookupValues[i - 1];
        }
        return lookupValues;
    }
}
