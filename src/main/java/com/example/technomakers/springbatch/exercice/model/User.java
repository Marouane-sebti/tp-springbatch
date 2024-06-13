package com.example.technomakers.springbatch.exercice.model;

public class User {
        private String identifier;
        private String accessCode;
        private String recoveryCode;
        private String firstName;
        private String lastName;
        private String department;
        private String location;


        public String getIdentifier() { return identifier; }
        public void setIdentifier(String identifier) { this.identifier = identifier; }

        public String getAccessCode() { return accessCode; }
        public void setAccessCode(String accessCode) { this.accessCode = accessCode; }

        public String getRecoveryCode() { return recoveryCode; }
        public void setRecoveryCode(String recoveryCode) { this.recoveryCode = recoveryCode; }

        public String getFirstName() { return firstName; }
        public void setFirstName(String firstName) { this.firstName = firstName; }

        public String getLastName() { return lastName; }
        public void setLastName(String lastName) { this.lastName = lastName; }

        public String getDepartment() { return department; }
        public void setDepartment(String department) { this.department = department; }

        public String getLocation() { return location; }
        public void setLocation(String location) { this.location = location; }

        @Override
        public String toString() {
            return "User{" +
                    "identifier='" + identifier + '\'' +
                    ", accessCode='" + accessCode + '\'' +
                    ", recoveryCode='" + recoveryCode + '\'' +
                    ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", department='" + department + '\'' +
                    ", location='" + location + '\'' +
                    '}';
        }
}

