public class KeyClass {
    final int value;

    public KeyClass(int value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        // Custom hash code to ensure the key goes to a specific bucket
        return value; // Assuming 16 buckets
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        KeyClass customKey = (KeyClass) obj;
        return value == customKey.value;
    }
}