# ComcastTechnicalAssessment
 * Goal: Given an Iterator of type Integer, provide an Iterator<Integer> implementation 
 *       that only provides non-negative values. Only implement next() and hasNext()
  
 This solution has a class that implements Itertor<> and parses the given Iterator, putting only positive values in a List. A pointer is also initialized to keep track what element is next for our iterator. If the pointer is less than the length of the list, then there is another positive Integer in our Iterator. 
  
Assumption: the terms "non-negative" and "positive" are used interchangeably in the directions, so it is unclear if zero should be included in our custom iterator. For this problem I excluded zero from being included in the possible responses.
