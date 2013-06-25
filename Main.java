import topcoder.EnemyTowers;
import topcoder.MatchString;
import topcoder.MazeOnFire;
import topcoder.datastructure.UndoHistory;
import topcoder.dp.ColorfulCupcakesDivTwo;
import topcoder.dp.SPartition;
import topcoder.dp.TravellingPurchasingMan;
import topcoder.graph.*;

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
    }
}
