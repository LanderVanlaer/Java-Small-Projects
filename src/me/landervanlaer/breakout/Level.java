package me.landervanlaer.breakout;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


//https://www.youtube.com/watch?v=HfGWVy-eMRc
//https://www.tutorialspoint.com/java_xml/java_dom_parse_document.htm
//https://www.codecoffee.com/simple-read-xml-file-java/

public class Level {

    private ArrayList<Block> blockList;
    private ArrayList<Ball> ballList;
    private Paddle paddle;

    public static void main(String[] args) {
        Level level = new Level(1);
        for(Block block : level.getBlockList()) {
            System.out.println(block.getPos().getX() + "    " + block.getPos().getY());
        }
    }

    public Level(int lvl) {
        try {
            File file = new File("src/me/landervanlaer/breakout/levels/level" + lvl + ".xml");
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document doc = documentBuilder.parse(file);
            doc.getDocumentElement().normalize();

            //----------- PADDLE -----------
            Element paddle = (Element) doc.getElementsByTagName("Paddle").item(0);
            this.setPaddle(new Paddle(
                    Integer.parseInt(paddle.getElementsByTagName("x").item(0).getTextContent()),
                    Integer.parseInt(paddle.getElementsByTagName("y").item(0).getTextContent())
            ));


            //----------- BALLS -----------
            NodeList balls = doc.getElementsByTagName("Ball");
            ArrayList<Ball> ballArrayList = new ArrayList<>();
            for(int i = 0; i < balls.getLength(); i++) {
                Element ball = (Element) balls.item(i);

                final int degreesMin = Integer.parseInt(ball.getElementsByTagName("min").item(0).getTextContent());
                final int degreesMax = Integer.parseInt(ball.getElementsByTagName("max").item(0).getTextContent());

                final int x = Integer.parseInt(ball.getElementsByTagName("x").item(0).getTextContent());
                final int y = Integer.parseInt(ball.getElementsByTagName("y").item(0).getTextContent());

                ballArrayList.add(new Ball(x, y, (int) (Math.random() * (degreesMax - degreesMin) + degreesMin)));
            }
            this.setBallList(ballArrayList);


            //----------- BLOCKS -----------
            NodeList blocks = doc.getElementsByTagName("Block");
            ArrayList<Block> blockArrayList = new ArrayList<>();
            for(int i = 0; i < blocks.getLength(); i++) {
                Element block = (Element) blocks.item(i);

                int x = Integer.parseInt(block.getElementsByTagName("x").item(0).getTextContent());
                int y = Integer.parseInt(block.getElementsByTagName("y").item(0).getTextContent());

                int width = Integer.parseInt(block.getElementsByTagName("width").item(0).getTextContent());
                int height = Integer.parseInt(block.getElementsByTagName("height").item(0).getTextContent());
                blockArrayList.add(new Block(x, y, width, height));
            }
            this.setBlockList(blockArrayList);


        } catch(ParserConfigurationException | IOException | SAXException e) {
            System.out.println("--------------------------------------------------------------");
            System.out.println("ERROR OCCURED");
            System.out.println("--------------------------------------------------------------\n");
            e.printStackTrace();
        }
    }

    public Paddle getPaddle() {
        return paddle;
    }

    public void setPaddle(Paddle paddle) {
        this.paddle = paddle;
    }

    public void addBall(Ball ball) {
        this.getBallList().add(ball);
    }

    public ArrayList<Ball> getBallList() {
        return ballList;
    }

    public void setBallList(ArrayList<Ball> balls) {
        this.ballList = balls;
    }

    public ArrayList<Block> getBlockList() {
        return blockList;
    }

    public void setBlockList(ArrayList<Block> blocks) {
        this.blockList = blocks;
    }

    public int getBallListSize() {
        return this.getBallList() != null ? this.getBallList().size() : 0;
    }

    public int getBlockListSize() {
        return this.getBlockList() != null ? this.getBlockList().size() : 0;
    }
}