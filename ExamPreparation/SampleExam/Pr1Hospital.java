package ExamPreparation.SampleExam;

import java.util.*;
import java.util.stream.Collectors;

public class Pr1Hospital {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, LinkedHashSet<String>> departments = new HashMap<>();
        Map<String, ArrayList<String>> doctors = new HashMap<>();


        String input = "";

        while(!"Output".equals(input = scanner.nextLine())) {
            String[] tokens = input.split("\\s+");

            String department = tokens[0];
            String doctor = tokens[1] + " " + tokens[2];
            String patient = tokens[3];

            if (!departments.containsKey(department)){
                departments.put(department, new LinkedHashSet<>());
            }

            departments.get(department).add(patient);

            if (departments.get(department).size() > 60){
                departments.get(department).remove(patient);
                continue;
            }

            if (!doctors.containsKey(doctor)){
                doctors.put(doctor, new ArrayList<>());
            }

            doctors.get(doctor).add(patient);

        }

        while(!"End".equals(input = scanner.nextLine())) {
            String[] tokens = input.split("\\s+");

            String firstValue = tokens[0];
            String doctorName = "";

            if (tokens.length == 2){

                if (Character.isDigit(tokens[1].charAt(0))){
                    int secondValue = Integer.parseInt(tokens[1]);

                    if (departments.containsKey(firstValue)){
                        LinkedHashSet<String> patientsAsSet = departments.get(firstValue);
                        List<String> patients = patientsAsSet.stream().collect(Collectors.toList());

                        ArrayList<String> patientsSorted = new ArrayList<>();


                        for (int i = secondValue * 3 - 3; i < secondValue * 3 ; i++) {
                            patientsSorted.add(patients.get(i));
                        }

                        patientsSorted.sort(String::compareTo);

                        for (String s : patientsSorted) {
                            System.out.println(s);
                        }
                    }

                    continue;
                } else {
                    String secondValue = tokens[1];
                    doctorName = firstValue + " " + secondValue;

                    if (departments.containsKey(firstValue)){
                        departments.get(firstValue).forEach(System.out::println);
                    } else if (doctors.containsKey(doctorName)){
                        ArrayList<String> patients = doctors.get(doctorName);

                        patients.sort(String::compareTo);

                        doctors.get(doctorName).forEach(System.out::println);
                    }

                    continue;
                }

            }

            if (departments.containsKey(firstValue)){
                departments.get(firstValue).forEach(System.out::println);
            }
        }
    }
}
