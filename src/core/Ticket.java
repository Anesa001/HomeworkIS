package core;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

public class Ticket {
    private int id;
    private String movieTitle;
    private String genre;
    private LocalDate validityDate;
    private BigDecimal price;

    public Ticket(String movieTitle, LocalDate validityDate, BigDecimal price) {
        this.id = id;
        this.movieTitle = movieTitle;
        this.validityDate = validityDate;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public LocalDate getValidityDate() {
        return validityDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    // Additional methods as per the task requirements

    public boolean isValidForDate(LocalDate date) {
        return validityDate.equals(date);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", movieTitle='" + movieTitle + '\'' +
                ", validityDate=" + validityDate +
                ", price=" + price +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public void setValidityDate(LocalDate validityDate) {
        this.validityDate = validityDate;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isValid(Date date) {
        return date.equals(validityDate) ;
    }

    public Object getGenre() {
        return genre;
    }

    public void setGenre(Object genre) {
        this.genre = (String) genre;
    }
}
