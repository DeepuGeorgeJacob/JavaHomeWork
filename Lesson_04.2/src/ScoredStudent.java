import java.util.Comparator;

public class ScoredStudent extends Student implements Comparable<ScoredStudent>, Comparator<ScoredStudent> {

    private final double percentComplete;

    public ScoredStudent(final int id) {
        super(id);
        this.percentComplete = random.nextDouble(0, 100.001);
    }

    public double getPercentComplete() {
        return percentComplete;
    }

    @Override
    public String toString() {
        return "%s %8.1f%%".formatted(super.toString(), percentComplete);
    }

    @Override
    public boolean matchFieldValue(String fieldName, String value) {
        if (fieldName.equalsIgnoreCase("percentComplete")) {
            return percentComplete <= Double.parseDouble(value);
        }
        return super.matchFieldValue(fieldName, value);
    }

    @Override
    public int compareTo(ScoredStudent other) {
        return Integer.compare(this.getId(), other.getId());
    }

    @Override
    public int compare(ScoredStudent o1, ScoredStudent o2) {
        return o1.getYearStarted() - o2.getYearStarted();
    }
}
