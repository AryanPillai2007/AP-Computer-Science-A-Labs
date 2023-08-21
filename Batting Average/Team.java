public class Team {
    battingAverage[] players;

    public Team()
    {
        players = new battingAverage[9];
    }

    public Team(int numPlayers)
    {
        players = new battingAverage[numPlayers];
    }

    public void printTeamStats()
    {
        for (int i = 0; i < players.length; i++)
            System.out.println(players [i].getName() + " # " + players [i].getNumber() + " average >>> " + players [i].getBattingAverageString());
    }

    public void printPlayerStats(int index)
    {
        System.out.println(players[index].getName() + " # " + players[index].getNumber() + " average >>> " + players [index].getBattingAverageString());
    }

    public int numPlayers()
    {
        return players.length;
    }

    public void addPlayer(battingAverage p, int index){

    }
}