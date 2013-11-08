import codechef.*;
import topcoder.*;
import topcoder.datastructure.UndoHistory;
import topcoder.dp.*;
import topcoder.graph.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 6/13/13
 * Time: 11:56 AM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    static void testPenLift(){
        PenLift object = new PenLift();
        String[] segments = {"-252927 -1000000 -252927 549481","628981 580961 -971965 580961",
                "159038 -171934 159038 -420875","159038 923907 159038 418077",
                "1000000 1000000 -909294 1000000","1000000 -420875 1000000 66849",
                "1000000 -171934 628981 -171934","411096 66849 411096 -420875",
                "-1000000 -420875 -396104 -420875","1000000 1000000 159038 1000000",
                "411096 66849 411096 521448","-971965 580961 -909294 580961",
                "159038 66849 159038 -1000000","-971965 1000000 725240 1000000",
                "-396104 -420875 -396104 -171934","-909294 521448 628981 521448",
                "-909294 1000000 -909294 -1000000","628981 1000000 -909294 1000000",
                "628981 418077 -396104 418077","-971965 -420875 159038 -420875",
                "1000000 -1000000 -396104 -1000000","-971965 66849 159038 66849",
                "-909294 418077 1000000 418077","-909294 418077 411096 418077",
                "725240 521448 725240 418077","-252927 -1000000 -1000000 -1000000",
                "411096 549481 -1000000 549481","628981 -171934 628981 923907",
                "-1000000 66849 -1000000 521448","-396104 66849 -396104 1000000",
                "628981 -1000000 628981 521448","-971965 521448 -396104 521448",
                "-1000000 418077 1000000 418077","-1000000 521448 -252927 521448",
                "725240 -420875 725240 -1000000","-1000000 549481 -1000000 -420875",
                "159038 521448 -396104 521448","-1000000 521448 -252927 521448",
                "628981 580961 628981 549481","628981 -1000000 628981 521448",
                "1000000 66849 1000000 -171934","-396104 66849 159038 66849",
                "1000000 66849 -396104 66849","628981 1000000 628981 521448",
                "-252927 923907 -252927 580961","1000000 549481 -971965 549481",
                "-909294 66849 628981 66849","-252927 418077 628981 418077",
                "159038 -171934 -909294 -171934","-252927 549481 159038 549481"};
        System.out.println(object.numTimes(segments, 5));
    }
    public static void testUndoHistory(){
        String[] lines ={"tomorrow", "topcoder"};
        System.out.println(new UndoHistory().minPresses(lines));
    }
    public static void testTravellingPurchasingMan(){
        int N = 5;
        String[] interestingStores = {"0 1000 17"};
        String[] roads = {"2 3 400", "4 1 500", "4 3 300", "1 0 700", "0 2 400"};
        System.out.println(new TravellingPurchasingMan().maxStores(N, interestingStores, roads));
    }
    public static void testFoxAndMp3(){
        String[] list = new FoxAndMp3().playList(1000000000);
        for(String item : list){
            System.out.println(item);
        }
    }
    public static void testArcadeManao(){
        String[] level =
                {"XXXXXXXXXX",
                        "...X......",
                        "XXX.......",
                        "X.....XXXX",
                        "..XXXXX..X",
                        ".........X",
                        ".........X",
                        "XXXXXXXXXX"};
        System.out.println(new ArcadeManao().shortestLadder(level, 1, 1));
    }
    public static void testSPartition(){
        System.out.println(new SPartition().getCount(""));
    }
    public static void testTeamContest(){
        int[] strength = {53,47,88,79,99,75,28,54,65,14,22,13,11,31,43};
        System.out.println(new TeamContest().worstRank(strength));
    }
    public static void testColorfulWolves(){
        String[] colormap = {
                "NYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY",
                "YNYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY",
                "YYNYYYYYYYYYNNNNNYYYYYYNNNNNYYYYYNNYYYNNYYYYYYYYYY",
                "YYYNYYYYYYYNYYYYYYYYYYYNYYYYNYYYYNYNYNYNYYYYYYYYYY",
                "YNNNNYYYYYYNYYYYYYYYYYYNYYYYNYYYYNYNYNYNYYYYYYYYYY",
                "YYYYYNYYYYYYNNNNNYYYYYYNNNNNYYYYYNYYNYYNYYYYYYYYYY",
                "YYYYNNNNNYYYYYYYYNYYYYYNYYYNYYYYYNYYNYYNYYYYYYYYYY",
                "YYYYYYYNYYYYYYYYYNYYYYYNYYYYNYYYYNYYYYYNYYYYYYYYYY",
                "YYYYYYYYNYYYNNNNNYYYYYYNYYYYNYYYYNYYYYYNYYYYYYNYYY",
                "YYNNNYYYYNYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYNYYYY",
                "YYYYYYYYYYNYYNNNNNNNNYYYYYYYYNNNNNNYYYYYYYYYNNYYYY",
                "YYYYYYYYYYYNYYYYYYYYYYNNNNNNYNYYYYYYYYYYYYYYYNYYYY",
                "YYYNNNNNYYYYNYYYYYYYYYYYYYYYYYYYYNNNNNYYYYYNNYYYYY",
                "YYYYYYYYYYYYYNYYYYYNNNNYYYYYYNNNNNYYYYYNNNNYYYYYYY",
                "YYYYNNNNYYYYYYNYYYYYYYYYYYYYYYYYYYNNNNNYYYYYYYYYYY",
                "YYYYYYYYYYYYYYYNYYNNNNNNNNNYYYYYYYYYYYYYYYYYYYYYYY",
                "YYNNNNNNYYYYYYYYNYYYYYYYYYYYNNNNYYYYYYYYYYNNNNNYYY",
                "YYNYYYYYNNNYYYYYYNYYYYYYNNNNNNNNNYYYYYYYYYYYYYYYYY",
                "YYYYNYYYYYYYNNNYYYNYYYYYYYYYYYYYNNNNNNYYYYYYYYYYYY",
                "YYYYYYNYYYNNNNYYYYYNYYYYYYYYYYYYYYYYYNNNNNYYYYYYYY",
                "NNNNNYYYYYYYNYYYYYYYNYYYYYYYYYYYNNNNNNNNYYYYYYYYYY",
                "YYYYYYYYYYYYYNNNNYYYYNYYYNNNNYYYYYYYYYYYYNNNNNNYYY",
                "YYYYNNNYYYYNNNNYYYYYYYNYYYYYYYYYYYYYNNNNNNYYYYYYYY",
                "YYYYYYYYYYYYYYYYYYYYYYYNYYYNNNYYYYNNNNYYYYYYYYYYYY",
                "YYYYYYYYYNNNNNYYYYYYYYYYNYYYYYNNNNYYYYYYYYYYYYYYYY",
                "YYYNNNNYYYYYYYYYYYYYYYYYYNYYYYYNNNNYYYYYNNNNNYYYYY",
                "YYYYYYYYYYYNNNNNYYYYYYYYYYNYYYYYYYYYYNNNNNYYYYYYYY",
                "YYYNNNNNNYYYYYYNNNNNYYYYYYYNYYYYYYYYYYYYYYYYYYYYYY",
                "YYYYYNNNNNYYYYYYNNNNNYYYYYYYNYYYYYYYNNNNNNYYYYYYYY",
                "YYNNNNNYYYYYYYYYYYYYYYYYYYNNNNNNYYYYYYYYYYYYYNNNYY",
                "YYYYNNNNNYYYYYYYYYNNNNNNNNNYYYNYYYYYYNNNNNYYYYYYYY",
                "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYNYYYNNNNNNYYYYYYYYY",
                "YYYYYYYYYYYYYNNNNNNYYYYYYNNNNNNYNYYYYYYYYYNNNYYYYN",
                "YYYYYNNNNNNNNYYYYYYNNNNNYYYYYYYYYNYYYYYYYYNNNNNYYY",
                "YYYYYYYYYYYYYYYYYYYYYYYYNNNNYYYYYYNYYYYYYYYYYYYYYY",
                "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYNNNNNNNYYYYYYYNNNNNY",
                "YYYNNNNNNNNYYYNNNNNNNNYYYYNYYYYYYYYYNYYYYYYYYYYYYY",
                "YYYNYYYYYYYYYYNYYYYYYYYYNNNYYYYYYYYYYNYYYYYYYYYYYY",
                "YYYNYYYYYYYYYYNYYYYYYYYYYYNYYYYYYNNNNNNYYYNNNNNYYY",
                "YYYNYYYYYYYYYYNYYYYYYYYYYYNYYYYYYYYYYYYNYYYYYYYYYY",
                "YYYNYNNNNYYYYYNYNNNNYYYYYYNYYYYYYYYYNNNNNNYYYYYYYY",
                "YYYNNYYYYNYYYYNNYYYYNYYYYYNYYYYYYYYYYYYYYNYYYYYYYY",
                "YYYNYYYYYYNYYYNYYYYYYNYYYYNYYYYYYYYYYYYYYYNYYNNNNY",
                "YYYYYYYYYYNYYYYYYYYYYNYYYYNYYYYYNNNNNNYYYYYNYYYYYY",
                "YYYYYYYYYYNYYYYYYYYYYNYYYYNYYYYYYYYYYYNNNNNNNYYYYY",
                "YYYNYYYYYNYYYYNYYYYYNYYYYYNYYYNNNNNNNNNNNNYYYNYYYY",
                "YYYYNNNNNYYYYYYNNNNNYYYYNNNNNYYYNNNNNNYYYNNNNYNYYY",
                "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYNYY",
                "YYYYNNNNYYYYNNNNNNNNNNNNYYYYYNNNNNNNNNYYYYYYYYYYNY",
                "YYYYYYNYYYYYYYYYYYYYYNYYYYYYYYYYYYYYYYYYYYYNYYYYYN"
        };
        System.out.println(new ColorfulWolves().getmin(colormap));

    }
    public static void testColorfulCupcakesDivTwo(){
        String cupcakes = "AAAAAAAAAABBBBBBBBBBBBBCCCCC";
        System.out.println(new ColorfulCupcakesDivTwo().countArrangements(cupcakes));
    }

    public static void testActivateGame(){
        String[] grid = {"AAA",
                "AAA",
                "AAA"}
                ;
        System.out.println(new ActivateGame().findMaxScore(grid));
    }

    public static void testTopView(){
        String[] grid =
                {"aabbaaaaaaaaaaaaaaaaaa",
                        "aabbccccccccccccccaaaa",
                        "aab11111ccccccccccaaaa",
                        "aab12221ccccccccccaaaa",
                        "aab12221ccccccccccaaaa",
                        "aab12221ccccccccccaaaa",
                        "aab12221ccccccccccaaaa",
                        "aab12221ccccccccccaaaa",
                        "aab12221ddddddddddaaaa",
                        "aab13331DDDDDDDDDDaaaa",
                        "aab13331DDDDDDDDDDaaaa",
                        "aa.11111DDDDDDDDDDaaaa",
                        "aaaaaaaaaaaaaaaaaaaaaa"};

        System.out.println(new TopView().findOrder(grid));

    }
    public static void testJumpingBoard(){
        String[] board =
                {"2H9HH11",
                        "HHHHH11",
                        "9HHHH11"}


                ;
        System.out.println(new JumpingBoard().maxJumps(board));
    }
    public static void testRabbitJumping(){
        int[] holes = {};
        System.out.println(new RabbitJumping().getMinimum(holes, 3));
    }
    public static void testMazeOnFire(){
        String[] maze =
                {"...$..",
                        "..#...",
                        "..###.",
                        "..#...",
                        "F.#.F."}
                ;
        System.out.println(new MazeOnFire().maximumTurns(maze));
    }
    public static void testEnemyTowers(){
        System.out.println(new EnemyTowers().attack(200
                ,50
                ,3
                ,10
                ,5
        ));
    }
    public static void testGameOnABoard(){
        String[] cost =
                {"110010100101010110100010001100111011",
                        "001000000110100011010100000001001000",
                        "011000110111101001011101110111000100",
                        "111001011000100101111010100110110011",
                        "111000011101001010000100001010000010",
                        "111001110010100101000001001100011011",
                        "111110100111010101100000100111000111",
                        "011111111100100111111110000001110111",
                        "110000010101001111100011110000001000",
                        "010010110111111100011101100000011010",
                        "110001100001111001101000101110110001",
                        "110010000111011110000010110111010101",
                        "100100110101001001101000001101101101",
                        "001011101101001100111110101111001110",
                        "111010111111111100110100000011111100",
                        "110101101000001001000100101011100000",
                        "011011001011010001001000100000110101",
                        "011111111100000011010111010011010100",
                        "111001111110001110001110010100111010",
                        "000001111000001100101010000001101110",
                        "010000110000010010111110111000010101",
                        "100010010100110011000111101001101011",
                        "111010110001101011010001111101111100",
                        "000111110000110000000101100101000110",
                        "110000010111001001110001101010111100",
                        "011111101101001011011010011111100010",
                        "110101111101010100110010000011001101",
                        "101101111001010100101111100001110001",
                        "000110010100101111011011110010010010",
                        "110101010011101000111011100000010011",
                        "110001010001110011010100110000010001",
                        "111010101100111100100011001101010100",
                        "011000000000100001011010000100010001",
                        "100000110110000001010001001111010000",
                        "100011111110010011011011001110011111",
                        "101100001111100101001101100000100001",
                        "010000111011010110011001110011111000",
                        "100010100111110111001010100101111010",
                        "000110011110111011111000101000001000"}
                ;

        System.out.println(new GameOnABoard().optimalChoice(cost));
    }
    public static void testMatchString(){
        String matchString = "TOP";
        String[] matchWords = {"OUTTHERE",
                "FROM",
                "NOPQRSTU"};
        System.out.println(new MatchString().placeWords(matchString, matchWords));
    }
    public static void testKingdomReorganization(){
        String[] kingdom = {"0000000000","0000000011","0001010000","0010010000","0000001000","0011000000","0000100000","0000000011","0100000101","0100000110"};
        String[] build = {"AhPEqkSFMM","hAfKPtsDad","PfAyGQkaqN","EKyAeLpRpm","qPGeASfNwo","ktQLSAnCAK","SskpfnAdJS","FDaRNCdAZz","MaqpwAJZAn","MdNmoKSznA"};
        String[] destroy = {"AgTqWWxEYH","gAXPgjzIRA","TXAleTmWvT","qPlAQkwxRO","WgeQAqgbJJ","WjTkqAiTzl","xzmwgiAuHb","EIWxbTuAwk","YRvRJzHwAn","HATOJlbknA"};
        System.out.println(new KingdomReorganization().getCost(kingdom, build, destroy));
    }
    public static void testAcronyms(){
        String[] words = {"Don't","worry.","Be","Happy!"};
        System.out.println(new Acronyms().acronize(words));
    }
    public static void testSpreadingNews(){
        int[] s = {-1, 0, 0, 1, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 7, 7, 8, 12, 13, 14, 16, 16, 16};
        System.out.println(new SpreadingNews().minTime(s));
    }
    public static void testFloorIndicator(){
        String[] indicator = {"...",
                ".#.",
                "...",
                "...",
                "..."}
                ;

//        String[] indicator = {"###.###",
//                "#.#.#.#",
//                "#.#.###",
//                "#.#...#",
//                "###.###"};
        System.out.println(new FloorIndicator().averageFloor(1, indicator));
    }
    public static void testPickGuitars(){
        int[] values = {2,1,4,1,2,1,8,1};
        System.out.println(new PickGuitars().maxValue(values));
    }
    public static void testGreedyGovernment(){
        String[] tolls = {"X32X", "XXXX", "XXXX", "XXXX"};
        System.out.println(new GreedyGovernment().maxAverageCost(tolls, 76));
    }
    public static void testContractWork(){
        String[] costs = {"44 92 2 78 13",
                "36 47 76 41 71",
                "59 27 59 35 16",
                "40 63 7 72 76",
                "49 80 45 67 33"};
        System.out.println(new ContractWork().minimumCost(costs, 5));
    }

    public static void testFloodRelief(){
        String[] heights = {"ccccc",
                "ccccc"}
                ;
        System.out.println(new FloodRelief().minimumPumps(heights));
    }
    public static void testPalindromeGame(){
        String[] front = { "abc" }
                ; int[] back={ 24 };
        System.out.println(new PalindromeGame().getMaximum(front, back));
    }
    public static void testLightedPanels(){
        String[] board = {"*...",
                "**..",
                "..**",
                "...*"}

                ;
        System.out.println(new LightedPanels().minTouch(board));
    }
    public static void testIdealString(){
        System.out.println(new IdealString().construct(7));
    }
    public static void testLandAndSea(){
        String[] seaMap = {
                "............",
                ".......xxxx.",
                "..xxx.x...x.",
                "..x..x..x.x.",
                "..x.x.x...x.",
                "..xx...xxx.."
        };
        int[] result = new LandAndSea().howManyIslands(seaMap);
        for(int i : result) System.out.println(i);
    }
    static void testImportsList(){
        String[] requires = {"NYYNYNYYYNYYNYNN"
                ,"NNNNNNNNNNNNNNNN"
                ,"NNNNNNNNNNYNNNNN"
                ,"NNNNNNNNNYNNYNNN"
                ,"NYNNNNYNNNYYNNNN"
                ,"NYNNYNYNYNYYNNNN"
                ,"NNNNNNNNNNYNNNNN"
                ,"NNYNNNYNYNYNNNNN"
                ,"NNNNNNYNNNYNNNNN"
                ,"NNNNNNNNNNNNYNNN"
                ,"NNNNNNNNNNNNNNNN"
                ,"NNNNNNNNNNNNNNNN"
                ,"NNNNNNNNNNNNNNNN"
                ,"NNNNNNYNNNYNNNNN"
                ,"YYYYYNYYYYYYYYNY"
                ,"NYYYNNYNNYYNYYNN"}
                ;
        int[] result = new ImportsList().importsCount(requires);
        for(int i : result) System.out.println(i);
    }
    static void testCollectingMarbles(){
        int[] weights = { 2, 2, 2 };
        int capacity = 1;
        int m = 10;
        System.out.println(new CollectingMarbles().mostMarbles(weights, capacity, m));
    }
    static void testUnionOfIntervals(){
        int[] lowerBound = { 1, 2 , 4 };
        int[] upperBound = { 7, 9 , 10 };
        int n = 1000000;
        System.out.println(new UnionOfIntervals().nthElement(lowerBound, upperBound, n));
    }
    static void testEqualTowers(){
        int[] bricks = { 14, 3, 20, 15, 15, 14, 24, 23, 15 };
        System.out.println(new EqualTowers().height(bricks));
    }
    static void testAutoMarket(){
        int[] cost = {9000, 6000, 5000, 5000, 7000};
        int[] features =  {1, 3, 4, 5, 2};
        int[] fixedTimes = {10, 6, 6, 5, 9};

        System.out.println(new AutoMarket().maxSet(cost, features, fixedTimes));
    }
    static void testCheapestRoute(){
        int[] cost = {1,2,-1};
        int[] enters = {0};
        int[] exits = {2};
        int tpc = 1000;
        int[] result =  new CheapestRoute().routePrice(cost, enters, exits, tpc);
        if(result.length>0) System.out.println(result[0] +" " +result[1]);
    }
    static void testDancingCouples(){
        String[] canDance = {"YYNNNN",
                "NYYNNN",
                "NNYYNN",
                "NNNYYN",
                "NNNNYY",
                "YNNNNY"};
        int k = 3;
        System.out.println(new DancingCouples().countPairs(canDance, k));
    }
    static void testTeamBuilder(){
        String[] paths = {"01000","00100","00010","00001","10000"}
                ;
        int[] result = new TeamBuilder().specialLocations(paths);
        ;
        System.out.println(result[0] + " " + result[1]);
    }
    static void testIngredientProportions(){
        String[] proportions = {"#4 and #0 as 1:1", "#4 and #1 as 3:1", "#4 and #2 as 5:1", "#4 and #3 as 7:1"};
        int[] result = new IngredientProportions().getMasses(proportions);
        for(int r : result) System.out.print(r+" ");
    }
    static void testSquares(){
        String[] field = {"AABCA", "AAAAA", "BAAAB", "AAAEA", "ADBFA"};
        System.out.println(new Squares().countSquares(field));
    }
    static void testPermissionTree(){
        String[] folders ={"0 Admin", "0 Bob,Joe,Bob", "0 Joe"};
        String[] users = {"Joe", "Bob"};
        int[] result = new PermissionTree().findHome(folders, users);
        for(int home : result) System.out.print(home+" ");
    }

    static void testBunnyConverter(){
        System.out.println(new BunnyConverter().getMinimum(499979,499979,499976,3));
    }

    static void testBagsQuiz(){
        String[] actions =
                {"PUT 1 INSIDE 2", "PUT 3 INSIDE 1"}

                ;
        System.out.println(new BagsQuiz().checkIfProper(3, actions));
    }

    static void testRookAttack(){
        String[] cutouts = {"0 0", "1 0"};
        System.out.println(new RookAttack().howMany(2,2,cutouts));

    }

    static void testTranspose(){
        System.out.println(new Transpose().numSwaps(5, 3));
    }

    static void testBadSubstring(){
        System.out.println(new BadSubstring().howMany(400));
    }
    static void testDiceGames(){
        int[] sides = {4,5,6};
        System.out.println(new DiceGames().countFormations(sides));
    }
    static void testRoadReconstruction(){
        String[] roads = {"O1 Beetown Fearnot 6","N7 Fearnot Hornytown","M8 Hornytown Belcher 10",
                "L5 Belcher Fearnot 8","C7 Fearnot Beetown 4","K7 Quiggleville Beetown 12",
                "H4 Beetown DryFork 6","Z0 Hornytown Belcher 1","O5 Belcher Quiggleville 10",
                "U7 Quiggleville Fearnot 2","A8 Fearnot Quiggleville 8","T6 Beetown DryFork 17",
                "E8 Quiggleville DryFork 8","Y4 DryFork Quiggleville 4","Q8 Hornytown DryFork 2",
                "J9 Quiggleville DryFork 19","M4 DryFork Quiggleville 7","T1 DryFork Fearnot 9",
                "G4 Fearnot DryFork 6","V9 Hornytown Beetown 5","O6 Quiggleville Beetown 4",
                "L8 Beetown Roachtown 5","D5 Belcher DryFork 8","W5 Belcher DryFork 1"}             ;
        System.out.println(new RoadReconstruction().selectReconstruction(roads));
    }
    static void testSkewedPerspectives(){
        int[] cubes = {0,1,0};
        int b = 3;
        int w = 2;
        String[] views = {"b","bb","bbb","bbbb","bbbbb","bbbbbb",
                "1", "1b","1bb","1bbb","1bbbb","1bbbbb","1bbbbbb",
                "b1","b1b","b1bb","b1bbb","b1bbbb","b1bbbbb",
                "bb1","bb1b","bb1bb","bb1bbb","bb1bbbb",
                "bbb1","bbb1b","bbb1bb","bbb1bbb",
                "bbbb1","bbbb1b","bbbb1bb",
                "bbbbb1","bbbbb1b",
                "bbbbbb1" };
        String[] valid = {"invalid",
                "valid",
                "valid",
                "valid",
                "valid",
                "valid",
                "valid",
                "valid",
                "valid",
                "valid",
                "valid",
                "valid",
                "valid",
                "invalid",
                "invalid",
                "invalid",
                "invalid",
                "invalid",
                "invalid",
                "valid",
                "valid",
                "valid",
                "invalid",
                "valid",
                "invalid",
                "invalid",
                "invalid",
                "invalid",
                "valid",
                "invalid",
                "valid",
                "invalid",
                "invalid",
                "valid" };
        String[] result = new SkewedPerspectives().areTheyPossible(cubes, b, w, views);
        for(int i=0; i<views.length; i++){
            if(!result[i].equals(valid[i])){
                System.out.println(views[i]+"  "+result[i]);
            }
        }
    }
    static void testOrderOfTheHats(){
        String[] spellChart = {"YYYYYNNYYYNYNNNNYNNY",
                "NYNNNYYNNYNYYYNYYYYY",
                "NNYNNNYYNNNNNNYYYYNY",
                "YYNYNYYNNYYYNYNNNYYY",
                "NYYNNYNYNYNNNNYYYNYN",
                "NNNNNYYNYNNYYYYNYYYN",
                "YNYNYYNNNYNNNNNYNNYY",
                "NYYYYNYNYNNYNNYNNNNY",
                "YYYYNYYNNYYYNNYNNYNY",
                "YYYYYYNYNYNYNNNNNNYN",
                "NNYYYYYNNNYNNNYNNNNY",
                "YYNNNYNYYNYYNYYNYNYN",
                "NNYNYYNYYNYYNYNYNYYN",
                "YNYNYYNYNNNYNYNYYNYY",
                "NNYNNNYYYYYYYYYYYNYY",
                "YYYYYNYYNYYYYYNNYNNN",
                "NYYYYYYYYNNNNNYYNNYN",
                "YNNYNNNYYNYYYNYNYYYY",
                "YYNNYNYYYNYYNNNYYNNY",
                "NNYNYNYYYNYYNYNNYNNN"}
                ;
        System.out.println(new OrderOfTheHats().minChanged(spellChart));
    }
    static void testMatrixGame(){
        String[] matrix = {"010",
                "000",
                "110"};
        String[] result = new MatrixGame().getMinimal(matrix);
        for(String s : result){
            System.out.println(s);
        }
    }
    static void testSpellCardsEasy(){
        int[] level = {1,2,1,1,3,2,1};
        int[] damage = {10,40,10,10,90,40,10};
        System.out.println(new SpellCardsEasy().maxDamage(level, damage));
    }
    static void testMagicNaming(){
        System.out.println(new MagicNaming().maxReindeers("knuthmorrispratt"));
//        String[] a = {"k", "nuthm", "o", "r", "ri", "spra", "t", "t"};
//        Arrays.sort(a);
//        String ret = "";
//        for(String s : a){
//            ret+=s;
//        }
//        System.out.println(ret);
    }
    static void testSafeRemoval(){
        int[] seq = {7,4,4};
        System.out.println(new SafeRemoval().removeThem(seq, 2));
    }
    static void testMagicalSquare(){
        String[] rowStrings = {"aa", "a", "aa"};
        String[] colStrings = {"aa", "a", "aa"};
        System.out.println(new MagicalSquare().getCount(rowStrings, colStrings));

    }
    static void testGalaxyTrip(){
        String[] dependencies = {"4 2", "3", "0 4", "1", "0 2", "6", "5"};
        int[] result = new GalaxyTrip().possibleValues(dependencies);
        for(int size : result) System.out.println(size+" ");
    }
    static void testTheTree(){
        int[] cnt = {4, 2, 1, 3, 2, 5, 7, 2, 4, 5, 2, 3, 1, 13, 6};

        System.out.println(new TheTree().maximumDiameter(cnt));
    }

    static void testYetAnotherTwoTeamsProblem(){
        int[] skill = {999, 999, 999, 1000, 1000, 1001, 999, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000,
                1000, 1000, 1000, 999, 1000, 512, 511, 1001, 1001, 1001, 1001, 1001, 1000};
        System.out.println(new YetAnotherTwoTeamsProblem().count(skill));
    }

    static void testMayTheBestPetWin(){
        int[] A = {2907,949,1674,6092,8608,5186,2630,970,1050,2415,1923,2697,5571,6941,8065,4710,716,756,5185,1341,993,5092,248,1895,4223,1783,3844,3531,2431,1755,2837,4015};
        int[] B = {7296,6954,4407,9724,8645,8065,9323,8433,1352,9618,6487,7309,9297,8999,9960,5653,4721,7623,6017,7320,3513,6642,6359,3145,7233,5077,6457,3605,2911,4679,5381,6574};
        System.out.println(new MayTheBestPetWin().calc(A, B));
    }

    static void testFlippingBitsDiv2(){
        String[] S = {"00010","11010110","1010111","110001010","0110001100"
                ,"000110110","011010101","00","111","100"};
        System.out.println(new FlippingBitsDiv2().getmin(S, 13));
    }

    static void quicksort(int[] array, int left, int right){
        if(left>=right) return;
        int pivot = array[left+ (int)Math.random()*(right-left+1)];
        int l = left, r = right;
        while(l<=r){
            while(array[l]<pivot) l++;
            while(array[r]>pivot) r--;
            if(l<=r){
                int tmp = array[l];
                array[l] = array[r];
                array[r] = tmp;
                l++; r--;
            }
        };
        quicksort(array, left, r);
        quicksort(array, l, right);
    }

    static void testThreeColorabilityEasy(){
        String[] cells = {"ZZ"
                ,"ZZ"};
        System.out.println(new ThreeColorabilityEasy().isColorable(cells));
    }
    static void testP8XCoinChangeAnother(){
        long[] result = new P8XCoinChangeAnother().solve(	58, 344845910552782105l, 198219266);
        for(long count : result) System.out.print(count+", ");
    }

    public static void main(String[] args){
//        testPenLift();
//        testUndoHistory();
//        testTravellingPurchasingMan();
//        testFoxAndMp3();
//        testArcadeManao();
//        testSPartition();
//        testTeamContest();
//        testColorfulWolves();
//        testColorfulCupcakesDivTwo();
//        testActivateGame();
//        testTopView();
//        testJumpingBoard();
//        testRabbitJumping();
//        testMazeOnFire();
//        testEnemyTowers();
//        testGameOnABoard();
//        testMatchString();
//        testKingdomReorganization();
//        testAcronyms();
//        testSpreadingNews();
//        testFloorIndicator();
//        testPickGuitars();
//        testGreedyGovernment();
//        testContractWork();
//        testFloodRelief();
//        testPalindromeGame();
//        testLightedPanels();
//        testIdealString();
//        testLandAndSea();
//        testImportsList();
//        testCollectingMarbles();
//        testUnionOfIntervals();
//        testEqualTowers();
//        testAutoMarket();
//        testCheapestRoute();
//        testDancingCouples();
//        testTeamBuilder();
//        testIngredientProportions();
//        testSquares();
//        testPermissionTree();
//        testBunnyConverter();
//        testBagsQuiz();
//        testRookAttack();
//        testTranspose();
//        testBadSubstring();
//        testDiceGames();
//        testRoadReconstruction();
//        testSkewedPerspectives();
//        testOrderOfTheHats();
//        testMatrixGame();
//        testSpellCardsEasy();
//        testMagicNaming();
//        testSafeRemoval();
//        testMagicalSquare();
//        testGalaxyTrip();
//        testTheTree();
//        testYetAnotherTwoTeamsProblem();
//        testMayTheBestPetWin();
//        testThreeColorabilityEasy();
//        testFlippingBitsDiv2();
//        testP8XCoinChangeAnother();


        try{
            SPOONS.main();
        } catch (Exception e){

        }

    }

}
