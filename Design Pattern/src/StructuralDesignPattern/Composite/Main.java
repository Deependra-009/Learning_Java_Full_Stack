package StructuralDesignPattern.Composite;

/**
 * Composite Design Pattern
 * */
public class Main {

    public static void main(String[] args) {

        File file1 = new File("resume.docx");
        File file2 = new File("photo.png");
        File file3 = new File("notes.txt");

        Folder documents = new Folder("Documents");
        Folder images = new Folder("Images");

        documents.add(file1);
        documents.add(file3);
        images.add(file2);

        Folder root = new Folder("Root");
        root.add(documents);
        root.add(images);

        root.showDetails();

    }
}
