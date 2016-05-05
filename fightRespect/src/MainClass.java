//import array.ArrayQuestions;
//import bowling.impl.BowlingAlleyImpl;
//import com.oracle.javafx.jmx.json.JSONFactory;
//import com.sun.org.apache.xerces.internal.xs.StringList;
//import dp.DpQuestions;
//import jdk.nashorn.internal.parser.JSONParser;
//import messaging.MessageTypeEnum;
//import messaging.TopicTypeEnum;
//import messaging.factories.MessageFactory;
//import messaging.impl.MessageRelayerImpl;
//import messaging.impl.PublisherImpl;
//import messaging.impl.ReceiverImpl1;
//import messaging.impl.ReceiverImpl2;
//import messaging.interfaces.Message;
//import messaging.interfaces.MessageRelayer;
//import messaging.interfaces.Publisher;
//import messaging.interfaces.Receiver;
//import producer.BlockingQueueImpl;
//import producer.Consumer;
//import producer.Producer;
//import string.StringQuestions;
//
//import java.util.*;
//
///**
// * Created by shlok.chaurasia on 25/02/16.
// */
//public class MainClass {
//
//    private static int askME(int M, Queue<Integer> group, int n) {
//        int moneyMade = 0;
//        for (int numberOfTimesMovieRan = 0; numberOfTimesMovieRan < M; numberOfTimesMovieRan++) {
//            int currentNumberOfPeople = 0;
//            int index = 0;
//
//            while (currentNumberOfPeople <= n && index < group.size()) {
//                int groupSize = group.peek();
//                if (currentNumberOfPeople + groupSize > n) {
//                    break;
//                }
//                currentNumberOfPeople += groupSize;
//                moneyMade += groupSize;
//                group.remove();
//                group.add(groupSize);
//                index++;
//            }
//        }
//        return moneyMade;
//    }
//
//    //    private static Boolean isInRange(double num)
////    {
////        return num >= -127 && num <=127;
////    }
//    private void printSum(int arr[]) {
//        int index1 = 0;
//        int index2 = index1 + 1;
//        int index3 = index2 + 1;
//        int sum1 = 0;
//        int sum2 = 0;
//        int sum3 = 0;
//
//        while (index1 < arr.length) {
//            if (index1 < arr.length) {
//                sum1 += arr[index1];
//                index1 += 3;
//            }
//            if (index2 < arr.length) {
//                sum2 += arr[index2];
//                index2 += 3;
//            }
//
//            if (index3 < arr.length) {
//                sum3 += arr[index3];
//                index3 += 3;
//            }
//
//        }
//        System.out.println(sum1 + " " + sum2 + " " + sum3);
//    }
//
//    private static void printStartEndIndex(String[] arr) {
//        int startIndex = -1;
//        int endIndex = -1;
//        int index = 1;
//        int prev = Integer.parseInt(arr[0]);
//        while (index < arr.length) {
//            int curr = Integer.parseInt(arr[index]);
//            if (prev < curr) {
//                prev = curr;
//                index++;
//                continue;
//            } else {
//                if (startIndex != -1) {
//                    startIndex = -1;
//                    endIndex = -1;
//                    break;
//                }
//                startIndex = index - 1;
//                int min = Integer.MIN_VALUE;
//                if (index - 2 >= 0)
//                    min = Integer.parseInt(arr[index - 2]);
//                while (index < arr.length && prev > curr) {
//                    prev = curr;
//                    curr = Integer.parseInt(arr[index]);
//                    if (min > curr) {
//                        startIndex = -1;
//                        endIndex = -1;
//                        break;
//                    }
//                    index++;
//                }
//
//                if (startIndex != -1) {
//                    endIndex = index - 1;
//                    prev = Integer.parseInt(arr[startIndex]);
//                } else
//                    break;
//            }
//        }
//        if (startIndex == -1)
//            System.out.println(-1 + " " + -1);
//        else
//            System.out.println((startIndex + 1) + " " + (endIndex + 1));
//    }
//
//    HashMap<String, Object> classProperties = new HashMap<String, Object>();
//
//    private void readClassComment(Scanner sc, String currLine)
//    {
//        while(!currLine.trim().equals("*/"))
//        {
//            if(currLine.contains("class"))
//            {
//                classProperties.put("class" , currLine.split("\\@class")[1].trim());
//            }
//            if(currLine.contains("author"))
//            {
//                classProperties.put("author" , currLine.split("\\@author")[1].trim());
//            }
//        }
//    }
//
//    private void classCode(Scanner sc, String currLine)
//    {
//        String s = "akjbsaj";
//
//    }
//    private void readInstanceVariable(Scanner sc)
//    {
//    }
//    private void readProperties()
//    {
//
//    }
//
//
//
//
//
//
//
//
//    Map<String, Integer> hashOutputMap = new HashMap<String, Integer>();
//
//    private void countRequestParamUrl(String startedLine) {
//        String requestType = startedLine.split(" ")[1];
//        String requestUrl = getUrl(startedLine.split(" ")[2]);
//        String requestIP = startedLine.split(" ")[4];
//
//        if (!hashOutputMap.containsKey(requestType)) {
//            hashOutputMap.put(requestType, 0);
//        }
//        if (!hashOutputMap.containsKey(requestUrl)) {
//            hashOutputMap.put(requestUrl, 0);
//        }
//        if (!hashOutputMap.containsKey(requestIP)) {
//            hashOutputMap.put(requestIP, 0);
//        }
//        hashOutputMap.put(requestType, hashOutputMap.get(requestType) + 1);
//        hashOutputMap.put(requestUrl, hashOutputMap.get(requestUrl) + 1);
//        hashOutputMap.put(requestIP, hashOutputMap.get(requestIP) + 1);
//    }
//
//    private void requestFormat(String line) {
//        String[] lines = line.split(" ");
//        String requestFormat = lines[lines.length - 1];
//        if (requestFormat.toLowerCase().equals("as"))
//            return;
//        if (!hashOutputMap.containsKey(requestFormat)) {
//            hashOutputMap.put(requestFormat, 0);
//        }
//        hashOutputMap.put(requestFormat, hashOutputMap.get(requestFormat) + 1);
//    }
//
//    private static Boolean isCompleted(String line) {
//        return line.split(" ")[0].toLowerCase().equals("completed");
//    }
//
//    private void responseCode(String line) {
//        String responseCode = line.split(" ")[1] + " " + line.split(" ")[2];
//        if (!hashOutputMap.containsKey(responseCode)) {
//            hashOutputMap.put(responseCode, 0);
//        }
//        hashOutputMap.put(responseCode, hashOutputMap.get(responseCode) + 1);
//    }
//
//    private static String getUrl(String fullUrl) {
//        fullUrl = fullUrl.replace("\"", "");
//        return fullUrl;
//    }
//
//    public static void main(String s[]) {
////
////        MainClass mainClass = new MainClass();
////        mainClass.hashOutputMap = new HashMap<String, Integer>();
////        Scanner sc = new Scanner(System.in);
////        String currLine = sc.nextLine();
////        while (!currLine.equals("***************###############***************")) {
////            mainClass.countRequestParamUrl(currLine);
////            String requestFormatLine = sc.nextLine();
////            if (requestFormatLine.trim().split(" ")[0].toLowerCase().equals("processing")) {
////                mainClass.requestFormat(requestFormatLine);
////                currLine = sc.nextLine();
////            } else {
////                currLine = requestFormatLine;
////            }
////            while (!isCompleted(currLine)) {
////                currLine = sc.nextLine();
////            }
////            mainClass.responseCode(currLine);
////            currLine = sc.nextLine();
////            if (!currLine.equals("***************###############***************")) {
////                currLine = sc.nextLine();
////                while(currLine.equals(""))
////                    currLine = sc.nextLine();
////            }
////        }
////        int count = 0;
////        while (count < 5) {
////            String key = sc.nextLine();
////            if (mainClass.hashOutputMap.containsKey(key))
////                System.out.println(mainClass.hashOutputMap.get(key));
////            else
////                System.out.println(0);
////            count++;
////        }
////        Scanner sc = new Scanner(System.in);
////        int totalSize = sc.nextInt();
////        int arr[] = new int[totalSize];
////        int index = 0;
////        while(index < arr.length)
////        {
////            arr[index] = sc.nextInt();
////            index++;
////        }
//
////        Scanner sc = new Scanner(System.in);
////        int totalCases = Integer.parseInt(sc.nextLine());
////        int index = 0;
////        while(index < totalCases)
////        {
////            int getLengthOfQueue = Integer.parseInt(sc.nextLine());
////            String nextLine = sc.nextLine();
////            String [] getQueue = nextLine.split(" ");
////            printStartEndIndex(getQueue);
//////            System.out.print(getLengthOfQueue);
//////            System.out.print(getQueue[0] + getQueue[1]);
////            index++ ;
////        }
//
//
////        Scanner sc = new Scanner(System.in);
////        int square = 0;
////        int rec = 0;
////        int otherPoly =0;
////        while(sc.hasNextLine())
////        {
////            String [] st = sc.nextLine().split(" ");
////            if(st.length<4)
////                break;
////            int side1= Integer.parseInt(st[0]);
////            int side2= Integer.parseInt(st[1]);
////            int side3= Integer.parseInt(st[2]);
////            int side4= Integer.parseInt(st[3]);
////            if(side1 < 0 || side2 < 0 || side3 < 0 || side4 < 0)
////                otherPoly++;
////            else if(side1==side2 && side2==side3 && side3==side4)
////                square++;
////            else if(side1 == side3 && side2== side4)
////                rec++;
////            else
////                otherPoly++;
////        }
////
////        System.out.println(square +" "+rec + " " + otherPoly);
//
////        Scanner sc = new Scanner(System.in);
////        String[] st = sc.nextLine().split(" ");
////        String output = st[0];
////        double prev = Double.parseDouble(st[0]);
////        for(int i = 1;i < st.length; i++)
////        {
////            double curDiff = Double.parseDouble(st[i]) -  prev;
////            if(!isInRange(curDiff))
////            {
////                output = output + " " + "-128";
////            }
////            output = output + " " + (int)curDiff;
////            prev = Double.parseDouble(st[i]);
////        }
////        System.out.println(output);
////        Scanner sc = new Scanner(System.in);
////        int N = sc.nextInt();
////        int M = sc.nextInt();
////        int index = 0;
////        Map<Integer,Integer> map = new HashMap<>();
////        int output = 1;
////        while(index < M)
////        {
////            int num = sc.nextInt();
////            if(map.containsKey(N-num))
////            {
////                output = 1;
////                break;
////            }
////            map.put(num, 1);
////            index ++;
////        }
////
////        System.out.print(output);
////
////        StringQuestions stringQuestions = new StringQuestions();
////
////        ArrayQuestions arrayQuestions= new ArrayQuestions();
////        stringQuestions.subStringSearch("ABCD", "BACDGABCDA");
////        int arr[] = { 10, 22, 9, 33, 11, 44,17,19};
////        arrayQuestions.LIS(arr);
////        arrayQuestions.quickSort(arr, 0, arr.length-1);
////        arrayQuestions.printArr(arr);System.out.println("");
//
////        System.out.println(arrayQuestions.binarySearch(13,arr,0,arr.length-1));
//        int arr1[] = {1, 2, 3, 4, -4, -5, -6};
////        arrayQuestions.mergeTwoHalves(arr1,0,3,arr1.length-1);
////        arrayQuestions.mergeSort(0,arr.length-1,arr);
////        arrayQuestions.printArr(arr);
//        DpQuestions dp = new DpQuestions();
////        dp.eggProblem(100, 2);
//
////        int arr1[] = {2,3,16,17,19};
////        int arr2[] = {1,5,12,14};
////        Scanner scanner = new Scanner(System.in);
////        String input = scanner.nextLine();
//////        arrayQuestions.mergeSortedArray(arr2, arr1);
////    System.out.print(stringQuestions.isPanagram(input));
////        stringQuestions.printPermutations(0, "ABC", "");
////        stringQuestions.firstNonRepeating("");
////        System.out.print("*");
////        stringQuestions.reverseWords("   i   like this program  very   much a");
////        stringQuestions.printEncoding("geeksforgeeks          ");
////        System.out.println("*");
////        HashMap<Integer,Integer> s1 = new HashMap<>();
////        HashMap<Integer,Integer> s12 = new HashMap<>(s1);
////        s1.put(1, 5);
////        s12.put(1,9);
////        System.out.println(s1.get(1));
////        System.out.println(s12.get(1));
//
////        stringQuestions.printIDSeq("DDIDDIID");
////        stringQuestions.printReverse(0, "");
////        Scanner sc = new Scanner(System.in);
////        int n = sc.nextInt();
//////
//////        for(int i = 0; i<n ;i++)
//////        {
//////
//////            int M = sc.nextInt();
//////            int N = sc.nextInt();
//////            int G = sc.nextInt();
//////            Queue<Integer> queue = new LinkedList<>();
//////            for(int gSize=0;gSize<G;gSize++)
//////            {
//////                queue.add(sc.nextInt());
//////            }
//////            System.out.println(askME(M, queue, N));
//////        }
////
////
////        Integer AArrivalAtB[]=null;
////        Integer AStart[]=null;
////        Integer BArrivalAtA[] = null;
////        Integer BStart[]=null;
////        Integer coolDown = 0;
////        for(int i =0;i<n;i++)
////        {
////            coolDown = sc.nextInt();
////            int aSize = sc.nextInt();
////            int bSize = sc.nextInt();
////            AArrivalAtB = new Integer[aSize];
////            AStart = new Integer[aSize];
////            for(int j = 0 ; j<aSize;j++)
////            {
////                String start = sc.next();
////                AStart[j] = convertToMinutes(start);
////
////                String arrivalAtB =sc.next();
////                AArrivalAtB[j] = convertToMinutes(arrivalAtB);
////            }
////            BArrivalAtA = new Integer[bSize];
////            BStart = new Integer[bSize];
////
////            for(int k = 0 ; k<bSize;k++)
////            {
////                String start = sc.next();
////                BStart[k] = convertToMinutes(start);
////
////                String arrivalAtA =sc.next();
////                BArrivalAtA[k] = convertToMinutes(arrivalAtA);
////            }
////            System.out.println(getBMax(BArrivalAtA, AStart, coolDown)+" "+getBMax(AArrivalAtB, BStart, coolDown));
////        }
////
////
////
////
////
//
////        demoThreading();
////        BowlingAlleyImpl bowlingAlley= new BowlingAlleyImpl();
////        bowlingAlley.initialize();
////        bowlingAlley.updateScore(4,1);
////        bowlingAlley.updateScore(3,1);
////        bowlingAlley.updateScore(5,1);
////        bowlingAlley.updateScore(7,1);
////        bowlingAlley.updateScore(1,1);
////        bowlingAlley.updateScore(3,1);
////        bowlingAlley.updateScore(2,1);
////        bowlingAlley.updateScore(2,1);
////        bowlingAlley.updateScore(4,1);
////        bowlingAlley.updateScore(5,1);
////        bowlingAlley.displayScores();
//
////        demoMessageBroker();
//
//    }
//
//    static Integer convertToMinutes(String time) {
//        int minutes = 0;
//        String[] hourMinute = time.split(":");
//        minutes += Integer.parseInt(hourMinute[0]) * 60;
//        minutes += Integer.parseInt(hourMinute[1]);
//        return minutes;
//    }
//
//    private static int getBMax(Integer arrivalAAtB[], Integer startTimeAtB[], int coolDown) {
//        Arrays.sort(arrivalAAtB, Collections.reverseOrder());
//        Arrays.sort(startTimeAtB);
//        int numberOfShips = startTimeAtB.length;
//        for (int arrivalA : arrivalAAtB) {
//            for (int startB : startTimeAtB) {
//                if ((arrivalA + coolDown) < startB) {
//                    numberOfShips--;
//                    if (numberOfShips == 0)
//                        return 0;
//                }
//            }
//        }
//        return numberOfShips;
//    }
//
//    private static void demoThreading() {
//        BlockingQueueImpl blockingQueue = new BlockingQueueImpl(10);
//        Thread consumer1Thread = new Thread(new Consumer(blockingQueue, 10));
//        consumer1Thread.setName("Consumer");
////        Thread consumer2Thread = new Thread(new Consumer(blockingQueue,10));
//        consumer1Thread.start();
////        consumer2Thread.start();
//        for (int i = 0; i < 2; i++) {
//            String message = ("Message" + i);
//            Thread thread = new Thread(new Producer(blockingQueue, 10, message));
//            thread.setName("Producer" + i);
//            thread.start();
//        }
//    }
//
////    private static void demoMessageBroker() {
////        Message<String> message1 = MessageFactory.createMessage(MessageTypeEnum.TYPE_1);
////        message1.setData("Testing1");
////        message1.setRank(1);
////
////        Message<String> message2 = MessageFactory.createMessage(MessageTypeEnum.TYPE_1);
////        message2.setData("Testing2");
////        message2.setRank(1);
////
////        Message<String> message3 = MessageFactory.createMessage(MessageTypeEnum.TYPE_1);
////        message3.setData("Testing3");
////        message3.setRank(1);
////
////        Message<String> message4 = MessageFactory.createMessage(MessageTypeEnum.TYPE_1);
////        message4.setData("Testing4");
////        message4.setRank(2);
////
////        Message<String> message5 = MessageFactory.createMessage(MessageTypeEnum.TYPE_1);
////        message5.setData("Testing5");
////        message5.setRank(2);
////
////        Receiver<String> receiver = new ReceiverImpl1<>();
////        Receiver<String> receiver1 = new ReceiverImpl2();
////        Publisher publisher = new PublisherImpl<>();
////        MessageRelayer messageRelayer = new MessageRelayerImpl<String>();
////        messageRelayer.subscribeReceiverToTopic(TopicTypeEnum.TYPE_1, receiver);
////        messageRelayer.subscribeReceiverToTopic(TopicTypeEnum.TYPE_2, receiver1);
////        messageRelayer.subscribeReceiverToTopic(TopicTypeEnum.TYPE_1, receiver1);
////        publisher.publish(message2, TopicTypeEnum.TYPE_1, 1);
////        publisher.publish(message1, TopicTypeEnum.TYPE_1, 1);
////        publisher.publish(message4, TopicTypeEnum.TYPE_2, 1);
////        publisher.publish(message3, TopicTypeEnum.TYPE_2, 1);
////        publisher.publish(message5, TopicTypeEnum.TYPE_2, 1);
////
////        messageRelayer.relayMessageToReceivers(TopicTypeEnum.TYPE_1, 1);
////        messageRelayer.relayMessageToReceivers(TopicTypeEnum.TYPE_2, 1);
////    }
//}
//
//
