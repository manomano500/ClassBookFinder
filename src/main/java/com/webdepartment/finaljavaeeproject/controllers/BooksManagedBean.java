/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.webdepartment.finaljavaeeproject.controllers;

import com.webdepartment.finaljavaeeproject.entities.Book;
import com.webdepartment.finaljavaeeproject.services.SubjectService;
import com.webdepartment.finaljavaeeproject.services.BooksService;
import com.webdepartment.finaljavaeeproject.entities.Subject;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;
import static jdk.nashorn.internal.objects.NativeError.getFileName;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;
import org.primefaces.util.IOUtils;


public class BooksManagedBean implements Serializable {

    @Inject
    private BooksService booksService;

    @Inject
    private SubjectService subjectService; // Added

    private String book_name;
    private Subject subject;

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Subject getSubject() {
        return subject;
    }

    private Part uploadedFile;

    public void setUploadedFile(Part uploadedFile) {
        this.uploadedFile = uploadedFile;
    }

           public void addBook() {
        try (InputStream input = uploadedFile.getInputStream()) {
            byte[] content = readBytes(input);

            Book book = new Book();
            book.setTitle(title);
            book.setAuthor(author);
            book.setContent(content);
            book.setSubjectId(subject);

            booksService.addBook(book);

            // Reset form fields after successful addition
            title = null;
            author = null;
            uploadedFile = null;

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Book added successfully", null));
        } catch (IOException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error uploading book", null));
            e.printStackTrace();
        }
    }

    private byte[] readBytes(InputStream input) throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] buffer = new byte[8192];
        int bytesRead;
        while ((bytesRead = input.read(buffer)) != -1) {
            output.write(buffer, 0, bytesRead);
        }
        return output.toByteArray();
    }

    // Other methods, such as handlePdfUpload and downloadBook, if needed

    private Subject book_subject;

    private int selectedSub; // Updated to Long type to store semester ID
    private Book selectedBook; // Updated to Long type to store semester ID
    private Book newBook; // Updated to Long type to store semester ID

    
        private String title;

    private String author;
//    private byte[] content;

//    public byte[] getContent() {
//        return content;
//    }
//
//    public void setContent(byte[] content) {
//        this.content = content;
//    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }


    
    
    
    public void setNewBook(Book newBook) {
        this.newBook = newBook;
    }

    public Book getNewBook() {
        return newBook;
    }

    public void setSelectedBook(Book selectedBook) {
        this.selectedBook = selectedBook;
    }
    
    

    public Book getSelectedBook() {
        return selectedBook;
    }
    private List<Book> booksList;

//    public void addBook() {
//        Book book = new Book();
//        book.setTitle(title);
//        book.setAuthor(author);
//        book.setContent(content);
////        book.setSubjectId(subjectService.findSubById(selectedSub));
//        booksService.addBook(book);
//    }
    
    
//    }
//////////////////////////////////////////////kave man/////////////////////
//    
//    public Map<String, String> getFileContents() {
//        return fileContents;
//    }
//
//    public void setFileContents(Map<String, String> fileContents) {
//        this.fileContents = fileContents;
//    }
//    public String getFileContentString() {
//        return fileContentString;
//    }
//
//    public void setFileContentString(String fileContentString) {
//        this.fileContentString = fileContentString;
//    }
//
//    
//    
//    
//    
//    private Part fileContent;  // Assuming you use JSF for file uploads
//    int currentUserId = (int) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userId");
//
//    private String fileName;
//    private Date upload_data;
//
//    private String fileContentString;  // Additional attribute to store file content
//    private Map<String, String> fileContents = new HashMap<>();
//    
//    public String addFile() {
//        Connection con = null;
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hellbase2", "root", "");
//            fileName = getFileName(fileContent);
//
//            // Insert file information into the database
//            String insertQuery = "INSERT INTO files (file_name, file_content, owner_user_id) VALUES (?, ?,  ?)";
//            try (InputStream contentStream = fileContent.getInputStream(); PreparedStatement statement = con.prepareStatement(insertQuery)) {
//
//                statement.setString(1, fileName);
//                statement.setBlob(2, contentStream);
//                statement.setInt(3, currentUserId);
//
//                int rowCount = statement.executeUpdate();
//
//                if (rowCount > 0) {
//                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("File added successfully!"));
//                } else {
//                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed to add file."));
//                }
//            }
//        } catch (Exception e) {
//
//            e.printStackTrace();
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("An error occurred while processing your request."));
//        } finally {
//            try {
//                if (con != null) {
//                    con.close();
//                }
//            } catch (Exception e) {
//
//                e.printStackTrace();
//            }
//        }
//        return "addFiles.xhtml?faces-redirect=true";
//    }
//
//
//////////////////////////////////////////////kave man/////////////////////
//
//   

    
   
    public void downloadBook(Book book) {
        byte[] content = book.getContent(); // Assuming getContent() retrieves the book content as byte[]

        // Prepare response for download
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        externalContext.responseReset();
        externalContext.setResponseContentType("application/pdf"); // Set the appropriate content type
        externalContext.setResponseContentLength(content.length);
        externalContext.setResponseHeader("Content-Disposition", "attachment;filename=\"" + book.getTitle() + ".pdf\""); // Set the file name

        // Write book contednt to the response stream
        try (InputStream is = new ByteArrayInputStream(content)) {
            byte[] buffer = new byte[8192];
            int length;
            while ((length = is.read(buffer)) > 0) {
                externalContext.getResponseOutputStream().write(buffer, 0, length);
            }
            facesContext.responseComplete();
        } catch (IOException e) {
            // Handle exception
            e.printStackTrace();
        }
    }
    
    
    
    private Part fileContent;  // Assuming you use JSF for file uploads

    public void setFileContent(Part fileContent) {
        this.fileContent = fileContent;
    }

    public Part getFileContent() {
        return fileContent;
    }

    
  
//    public void handlePdfUpload(FileUploadEvent event) {
//        try {
//            InputStream input = event.getFile().getInputStream();
//            ByteArrayOutputStream output = new ByteArrayOutputStream();
//            byte[] buffer = new byte[8192];
//            int bytesRead;
//            while ((bytesRead = input.read(buffer)) != -1) {
//                output.write(buffer, 0, bytesRead);
//            }
//            this.content = output.toByteArray();
//            FacesMessage message = new FacesMessage("PDF uploaded successfully");
//            FacesContext.getCurrentInstance().addMessage(null, message);
//        } catch (IOException e) {
//            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error uploading PDF", null);
//            FacesContext.getCurrentInstance().addMessage(null, message);
//            e.printStackTrace();
//        }
//    }


/////////////////////////////////Getters And Setters////////////////////////////
    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public void setBook_subject(Subject book_subject) {
        this.book_subject = book_subject;
    }

    public String getBook_name() {
        return book_name;
    }

    public Subject getBook_subject() {
        return book_subject;
    }

    public List<Book> getBooksList() {
        if (booksList == null) {
            booksList = booksService.getAllBooks();

        } else {
            booksList.clear();
            booksList = booksService.getAllBooks();
        }
        return booksList;
    }

    public void setSelectedSub(int selectedSub) {
        this.selectedSub = selectedSub;
    }

    public int getSelectedSub() {
        return selectedSub;
    }
}
   

