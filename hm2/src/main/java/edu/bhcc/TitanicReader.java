package edu.bhcc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *  a class that reads from a file
 */
public class TitanicReader {
    public File file;
    Logger logger=   LoggerFactory.getLogger(TitanicReader.class);

    public  TitanicReader(File file){
        this.file = file;
    }

    /**
     *
     * @return total number of passengers
     */
    public int getNumPassengers(){
        int passengers = -1;
        if (this.file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(this.file))) {
                while (( br.readLine()) != null) {
                    passengers++;
                }
            } catch (IOException e) {
                this.logger.error("error while reading file"+e);
            }
        } else {
            this.logger.warn("File does not exist");
        }
        this.logger.info("There are " + passengers + " passengers.");
        return passengers;
    }

    /**
     *
     * @return number of only first class passengers
     */
    public int getNumFirstClassPassengers(){
        int passengers = 0;
        if (this.file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(this.file))) {
                String line;
                while ((line =  br.readLine()) != null) {
                    if(Objects.equals(line.split(",")[2], "1")){
                    passengers++;
                    }
                }
            } catch (IOException e) {
                this.logger.error("error while reading file"+e);
            }
        } else {
            this.logger.warn("File does not exist");
        }
        this.logger.info("There are " + passengers + " first class passengers.");
        return passengers;
    }
    /**
     *
     * @return number of only second class passengers
     */

    public int getNumSecondClassPassengers(){
        int passengers = 0;
        if (this.file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(this.file))) {
                String line;
                while ((line =  br.readLine()) != null) {
                    if(Objects.equals(line.split(",")[2], "2")){
                        passengers++;
                    }
                }
            } catch (IOException e) {
                this.logger.error("error while reading file"+e);
            }
        } else {
            this.logger.warn("File does not exist");
        }
        this.logger.info("There are " + passengers + " second class passengers.");
        return passengers;
    }

    /**
     *
     * @return only third class passengers
     */
    public int getNumThirdClassPassengers(){
        int passengers = 0;
        if (this.file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(this.file))) {
                String line;
                while ((line =  br.readLine()) != null) {
                    if(Objects.equals(line.split(",")[2], "3")){
                        passengers++;
                    }
                }
            } catch (IOException e) {
                this.logger.error("error while reading file"+e);
            }
        } else {
            this.logger.warn("File does not exist");
        }
        this.logger.info("There are " + passengers + " third class passengers.");
        return passengers;
    }


}
