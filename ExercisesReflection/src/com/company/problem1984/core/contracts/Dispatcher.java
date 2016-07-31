package com.company.problem1984.core.contracts;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public interface Dispatcher {
   void readEntities(int entitiesCount) throws IOException;
   void readInstitutions(int institutionsCount) throws IOException;
   void executeChange(String[] changeTokens) throws IllegalAccessException, InvocationTargetException;
   void printChangeLog();
}
