public class LibrarySystem {
    public String[] titles = new String[100];
    public String[] authorNames = new String[100];
    public String[] authorCountries = new String[100];
    public int[] years = new int[100];
    public boolean[] borrowed = new boolean[100];
    public int count = 0;

    public void addBook(String title, String authorName, String authorCountry, int year) {
        titles[count] = title;
        authorNames[count] = authorName;
        authorCountries[count] = authorCountry;
        years[count] = year;
        borrowed[count] = false;
        count++;
    }

    public String[] findBooksByAuthor(String authorName) {
        String[] matches = new String[count];
        int idx = 0;
        for (int i = 0; i < count; i++) {
            if (authorNames[i].equals(authorName)) {
                matches[idx++] = titles[i];
            }
        }
        return matches;
    }

    public void borrowBook(String title) {
        for (int i = 0; i < count; i++) {
            if (titles[i].equals(title)) {
                borrowed[i] = true;
            }
        }
    }

    public void returnBook(String title) {
        for (int i = 0; i < count; i++) {
            if (titles[i].equals(title)) {
                borrowed[i] = false;
            }
        }
    }

    public void forceUpdateAuthor(int index, String newAuthorName, String newCountry) {
        authorNames[index] = newAuthorName;
        authorCountries[index] = newCountry;
    }
}
