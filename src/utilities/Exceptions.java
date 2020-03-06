package utilities;
public class Exceptions {

    public static int validateDay() {
        boolean comprobation = true;
        int day = 0;
        do {
            day = checkInt();
            comprobation = true;
            try {
                if (day < 0) {
                    throw new RuntimeException("NEGATIVE NUMBERS DO NOT EXITS");
                }
                if (day > 31) {
                    throw new RuntimeException("NUMBERS BIGGER THAN 31 DO NOT EXIT IN A MONTH");
                }
            } catch (RuntimeException ex) {
                System.out.println("Introduce a valid number");
                comprobation = false;
            }
        } while (comprobation == false);
        return day;
    }

    public static int validateMonth(int day) {
        boolean comprobation = true;
        int month = 0;
        do {
            month = checkInt();
            comprobation = true;
            try {
                if (month > 0) {
                    if (month < 13) {
                        if (day > 28) {
                            if (day == 29 || day == 30) {
                                if (month == 2) {
                                    throw new RuntimeException("THIS DAY DO NOT EXIT");
                                }
                            }
                            if (day == 31) {
                                if (month == 2 || month == 4 || month == 6 || month == 9 || month == 11) {
                                    throw new RuntimeException("THIS DAY DO NOT EXIT");
                                }
                            }
                        }
                    } else {
                        throw new RuntimeException("THIS MONTH DO NOT EXIT");
                    }
                } else {
                    throw new RuntimeException("NEGATIVE MONTHS DO NOT EXITS");
                }
            } catch (RuntimeException ex) {
                System.out.println("Introduce a valid month");
                comprobation = false;
            }
        } while (comprobation == false);
        return month;
    }

    public static int validateYear() {
        boolean comprobation = true;
        int year = 0;
        do {
            year = checkInt();
            comprobation = true;
            try {
                if (year < 0) {
                    throw new RuntimeException("NEGATIVE YEARS DO NOT EXITS");
                }
                if (year > 2020) {
                    throw new RuntimeException("WE ARE IN 2020");
                }
            } catch (RuntimeException ex) {
                System.out.println("Introduce a valid year");
                comprobation = false;
            }
        } while (comprobation == false);
        return year;
    }

    public static int checkInt() {
        int whole = 0;
        boolean comprobation = true;
        String read;
        do {
            read = Utilities.leer();
            comprobation = true;
            try {
                whole = Integer.parseInt(read);
            } catch (NumberFormatException ex) {
                System.out.println("Introduce whole number");
                comprobation = false;
            }
        } while (comprobation == false);
        return whole;

    }

    public static float checkFloat() {
        float f = 0;
        boolean comprobation = true;
        String read;
        do {
            read = Utilities.leer();
            comprobation = true;
            try {
                f = Float.parseFloat(read);
            } catch (NumberFormatException ex) {
                System.out.println("Introduce a whole real");
                comprobation = false;
            }
        } while (comprobation == false);
        return f;

    }

}
