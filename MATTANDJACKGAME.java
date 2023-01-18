
package mattandjackgame;

import java.util.ArrayList;
import java.util.Scanner;


//GAME CREATION LOG
//Exclamation marks are used as a tool to help the player read the text easier by seperating the texts displayed between each terrain
//An Arraylist is used to store all items picked up by the player during the game

public class MATTANDJACKGAME {

        Scanner playersName = new Scanner(System.in); //scanner for player's name
        Scanner playersChoice = new Scanner(System.in); //scanner for player's choices in the game
        
	int playerHealth; //health variable for the player
        int monsterHealth; //health variable for the monster
        int fallingCounter; //counter to be used during the "parachuting" method to give the player a consequence if the parachute is not pulled in a certain amount of choices
        
	String playerName; //player's name that remains the same throughout the game      
	int option; //variable to store player's choices in the game
	
        ArrayList<String> playerInventory = new ArrayList<String>(); //arraylist to store player's inventory items

		
	public static void main(String[] args) { //used to initiate the new game method
                
                //define class and method
		MATTANDJACKGAME gamer; 
		gamer = new MATTANDJACKGAME();
		
		gamer.newGame(); //executes the new game method	
		
	}
	
	public void newGame(){ //executes a new game
		
		playerInventory.add("Knife"); //player begins quest with default weapon
                
                
		playerHealth = 10; //sets the players health points to the default value
		monsterHealth = 15; //sets the health points of the "Gargoyle" boss to the default value
                fallingCounter = 0; //
               
                //Exclamation marks are used as a tool to help the player read the text easier by seperating the texts displayed between each terrain
                System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"); 
                System.out.println("STARTING NEW GAME"); //informs the player a new game has started
                System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"); 
                
                
                System.out.println("What is your adventurer's name?"); //asks player to input player name
                playerName = playersName.nextLine(); //uses "playersName" scanner to take input and assign string to variable
                System.out.println("Welcome aboard " + playerName + "!!! Welcome to DROPFALL!!"); //introduces player to the game
		System.out.println("Your HP: "+ playerHealth);  //shows players health
		System.out.println("Your have: "+ playerInventory + "in your inventory"); //shows players inventory
                System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"); 
                System.out.println("*PLEASE ONLY USE NUMERICAL VALUES FOR ANSWERS IN THIS GAME");
                System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"); 
		System.out.println("Would you like to start your game?"); //gives player an option
                System.out.println("1: Yes"); //option 1
		System.out.println("2: No"); //option 2
		option = playersChoice.nextInt(); //uses "playersChoice" scanner to take input from the player and selects the path they chose
		
		
		if(option==1){ //checks to see if code is to be run
			helicopter(); //game goes to first location
		}
                else if(option==2){ //checks to see if code is to be run
			quitGame(); //goes to game quit screen
		}
                else {
			newGame(); //repeats method if wrong value is entered
                }
	}
        
        
             public void helicopter(){ //helicopter location
		
		System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");
		System.out.println("You are a covert military operative on a mission"); //description of game for player
                System.out.println("You are 3000m above the ground in a helicopter");  //description of game for player
                System.out.println("Your leader Morpheus is waiting to brief you while he eats red jellybeans");  //description of game for player
		System.out.println("");
		System.out.println("What would you like to do?");  //asks player for input for following options
		System.out.println("");
		System.out.println("1: Ask Morpheus for the mission brief"); //option 1
		System.out.println("2: Ask Morpheus for a jelly bean "); //option 2
		System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");

		option = playersChoice.nextInt(); //uses "playersChoice" scanner to take input from the player and selects the path they chose
		
		if(option==1){ //checks to see if code is to be run
                    missionBrief(); //goes to next location 			
		}
		else if(option==2){ //checks to see if code is to be run
			System.out.println("Morpheus: HEY! These are mine!"); //npc says funny line
			helicopter(); //repeats method
		}
	                else {
			helicopter(); //repeats method if wrong value is entered
                }

	}
        
	public void missionBrief(){ //mission-brief location
		
		System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");
		System.out.println("Morpheus: Thanks for joining me on this mission " + playerName + ". "); //npc greets player
		System.out.println("Morpheus: This mission is to Sanity Island to infiltrate and steal the Master Emerald"); //description of game for player
                System.out.println("Morpheus: You will be parachuting into the island"); //description of game for player
                System.out.println("Morpheus: And I will be waiting at Sanity Beach once you have received the Emerald"); //description of game for player
                playerInventory.add("Parachute"); //player receives parachute from npc and it is added to inventory
                System.out.println("<Parachute was added to inventory>"); //log-look message for player to see parachute is in their iventory
		System.out.println("");
		System.out.println("Morpheus: Are you ready? " + playerName); //npc asks player for input
		System.out.println("");
		System.out.println("1: Yes. Let's go!"); //option1
		System.out.println("2: Can i wait a few minutes?"); //option2
		System.out.println("3: I'm scared"); //option3
                System.out.println("4: Can i hear the briefing again?"); //option4
		System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");

		option = playersChoice.nextInt(); //uses "playersChoice" scanner to take input from the player and selects the path they chose
		
		if(option==1){ //checks to see if code is to be run
		        if (playerInventory.contains("Parachute")){ //checks if item is in inventory
                            System.out.println("Morpheus: That's the Spirit!"); //npc says line to player
		            parachuting(); //goes to next location
			
                        }
                        else{ 
		           dead(); //if player does not talk to npc and does not recieve parachute the game ends
                        }
		}
		else if(option==2){//checks to see if code is to be run
                     if (playerInventory.contains("Parachute")){ //checks if item is in inventory
		      System.out.println("Morpheus: No. You have to go now"); //npc says line to player	
                      System.out.println("<Morpheus pushes you out of the helicopter>"); //informs player of transition to new location	
                      parachuting();  //goes to next location
                
		}
                         else{ 
		           dead(); //if player does not talk to npc and does not recieve parachute the game ends
                        }
		}
		else if(option==3){ //checks to see if code is to be run
		System.out.println("Morpheus: Don't be a wimp"); //npc line
                System.out.println("Morpheus: The fate of the world depends on you!"); //npc line
                missionBrief(); //repeats method
                
		}	
		else if(option==4){ //checks to see if code is to be run
		System.out.println("Morpheus: Sure"); //npc line
                missionBrief(); //repeats method
                }
                
                else {
		missionBrief(); //repeats method if wrong value is entered
                }         
	}
	public void parachuting(){ //parachuting location
                     
		System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");
		System.out.println("You are freefalling in the air towards sanity island"); //description of game for player
                System.out.println("");
                System.out.println("What do you do?"); //asks player for input
                System.out.println("");
		System.out.println("1: Keep Falling"); //option1
		System.out.println("2: Pull Parachute"); //option2
		System.out.println("3: Look at the island"); //option3
		System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");
		
		option = playersChoice.nextInt(); //uses "playersChoice" scanner to take input from the player and selects the path they chose
		
		if(option==1){ //checks to see if code is to be run
                        if (fallingCounter <3){ //if counter reaches a number higher than 3 the player would have reached the ground therefore ending the game
			System.out.println("You are accelerating towards the ground"); //informs player you are falling towards the ground
                        fallingCounter++; //increases the counter everytime iteration is run
                        parachuting(); //repeats method
                }
                        else{
                        dead(); //game over if the player has hit the ground       
                         }
		}
		else if(option==2){ //checks to see if code is to be run
			sanityIsland(); //goes to next location
		}
		else if(option==3){ //checks to see if code is to be run
			if (fallingCounter <3){ //if counter reaches a number higher than 3 the player would have reached the ground therefore ending the game
			System.out.println("The island is really beautiful but you are accelerating towards the ground"); //informs player you are falling towards the ground
                        fallingCounter++; //increases the counter everytime iteration is run
                        parachuting(); //repeats method
                }
                        else{
                        dead(); //game over if the player has hit the ground           
                         }
		}
                else {
		  parachuting(); //repeats method if wrong value is entered
                }
	}
        
        
        public void sanityIsland(){ //Centre of island location
                 
		System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");
		System.out.println("You are at the centre of Sanity Island. If you go south you go back to Sanity Beach"); //description of game for player
                System.out.println("");
                 if (playerInventory.contains("Master Emerald")){ //checks if master emerald is in the player's inventory
                    System.out.println("3: Go to Sanity Beach"); //option 3 is the only option as it guides players to the beach and to morpheus
                }     
                else{
                System.out.println("1: Go North"); //option 1
		System.out.println("2: Go East"); //option 2
		System.out.println("3: Go South"); //option 3
		System.out.println("4: Go West"); //option 4
                if (playerInventory.contains("Apple")){ //option 5 is only avaliable after has obtained item into the inventory
                    System.out.println("5: Eat Apple"); //option 5
                }    
		System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");
        } 
		
		
		option = playersChoice.nextInt(); //uses "playersChoice" scanner to take input from the player and selects the path they chose
		
		if(option==1){ //checks to see if code is to be run
			north(); //goes to north location
		}
		else if(option==2){ //checks to see if code is to be run
			east(); //goes to east location
		}
		else if(option==3){ //checks to see if code is to be run
			sanityBeach(); //goes to sanityBeach location
		}
		else if(option==4){ //checks to see if code is to be run
			town(); //goes to town location
		}
                else if(option==5){ //checks to see if code is to be run
			System.out.println("You recieved HP!"); //informs player the player health has increased
                        playerHealth = playerHealth + 3; //adds a value of "3" to the current health
                        System.out.println("Your HP is :" + playerHealth); //displays the new health value
                        playerInventory.remove("Apple"); // removes apple item from inventory as it has been consumed
                        sanityIsland(); //repeats method
		}
		else{
			sanityIsland(); //repeats method if wrong value is entered
		}
	}
	
         public void sanityBeach(){ //sanity beach location
                
               
		System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");
		System.out.println("Morpheus is waiting in the helicopter on the beach"); //description of game for player
                System.out.println("");
		System.out.println("1: Talk to him"); //option 1
		System.out.println("2: Look around"); //option 2
		System.out.println("3: Go Back"); //option 3
		System.out.println("4: Steal the helicopter"); //option 4
		System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");
		
		option = playersChoice.nextInt(); //uses "playersChoice" scanner to take input from the player and selects the path they chose
		
		if(option==1){ //checks to see if code is to be run
			 if (playerInventory.contains("Master Emerald")){ //checks to see if master emerald is in the inventory
                            
		            ending(); //goes to game ending
			
                        }
                        else{
		           System.out.println("Morpheus: Do you have the Master Emerald?"); //npc asks player to retrieve item
                           System.out.println("Morpheus: Come back when you have the emerald"); //npc asks player to retrieve item
                           sanityBeach(); //repeats method
                        }
                }     
		else if(option==2){ //checks to see if code is to be run
			System.out.println("You notice a plane wreckage on the other side of the beach"); //description of game for player
                        planeWreckage(); //goes to plane wreckage location
		}
		else if(option==3){ //checks to see if code is to be run
			sanityIsland(); //goes back to sanity island location
		}
		else if(option==4){ //checks to see if code is to be run
			System.out.println("Morpheus: Hey, stop trying to be a funny guy " + playerName); //npc says funny line to player
                        sanityBeach(); //repeats method
		}
		else{
			sanityBeach(); //repeats method if wrong value is entered
		}
	}
	
         public void planeWreckage(){ //plane wreckage location
		System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println("The plane wreck looks quite old"); //description of game for player
                System.out.println("The plane's shell is made of titanium"); //description of game for player
                System.out.println("<You have scavenged Titanium>"); //description of game for player
                playerInventory.add("Titanium"); //titanium has been added to the inventory
                System.out.println("<Titanium is now in your inventory>"); //game informs player of new inventory item            
		System.out.println("1: Go Back"); //option 1
		System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");
		
		option = playersChoice.nextInt(); //uses "playersChoice" scanner to take input from the player and selects the path they chose
		
		if(option==1){ //checks to see if code is to be run
			sanityBeach();  //goes back to sanity beach location
		}
		else{
			planeWreckage(); //repeats method if wrong value is entered
		}
	}
	public void north(){ //north location
		System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println("You encounter an Aggressive Echidna!");//description of game for player
                System.out.println("Monster HP: " + monsterHealth); //informs player of monster's health
                System.out.println("Your HP: "+ playerHealth); //informs player of their health
		System.out.println("1: Fight"); //option 1
		System.out.println("2: Run"); //option 2
		System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");
		
		option = playersChoice.nextInt(); //uses "playersChoice" scanner to take input from the player and selects the path they chose
		
		if(option==1){ //checks to see if code is to be run
			if (playerInventory.contains("Sword")){ //checks to see if player has a sword in their inventory. if it is true, the player can continue
                            System.out.println("You are ready for battle!"); //informs player that the battle is starting
		            battle(); //goes to battle screen
			
                        }
                        else{
		           System.out.println("Your weapon is too weak"); //informs player to get a new weapon before continuing
                           north(); //repeats method
                        }
		}
		else if(option==2){ //checks to see if code is to be run
			sanityIsland(); //goes back to prevoius location sanity island
		}
		else{
			north(); //repeats method if wrong value is entered
		}
	}
        
	public void town(){ //town location
		System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");
		System.out.println("You walk into the town"); //description of game for player
		System.out.println("There is a blacksmith shop and a bar"); //description of game for player
                System.out.println("");
                System.out.println("1: Go to the blacksmith"); //option 1
                System.out.println("2: Go to the bar"); //option 2
                System.out.println("3: Go back"); //option 3
		System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");
		
		option = playersChoice.nextInt(); //uses "playersChoice" scanner to take input from the player and selects the path they chose
		
		if(option==1){ //checks to see if code is to be run
	             blacksmithShop(); //goes to blacksmith shop location
			
		}
		else if(option==2){ //checks to see if code is to be run
                     bar(); //goes to bar location
		}
		else if(option==3){ //checks to see if code is to be run
			sanityIsland(); //goes back to sanity island location
		}	
		else{
			town(); //repeats method if wrong value is entered
		}
	}
	
        public void blacksmithShop(){ //blacksmith shop location
		System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");
		System.out.println("There is a blacksmith"); //description of game for player
                System.out.println("");
		System.out.println("What do you do?");//game asks player for input
		System.out.println("");
                System.out.println("1: Talk to the blacksmith"); //option 1
                System.out.println("2: Attack the blacksmith"); //option 2
                System.out.println("3: Go back"); //option 3
		System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");
		
		option = playersChoice.nextInt(); //uses "playersChoice" scanner to take input from the player and selects the path they chose
		
		if(option==1){ //checks to see if code is to be run
			if(playerInventory.contains("Titanium")){ //checks to see if player has "titanium" in their inventory
				System.out.println("Blacksmith: Thank you " + playerName + " I can craft many weapons with these"); //npc thanks player
                                System.out.println("<Sword has been added to inventory>"); //log-message for player to see new item in inventory
                                playerInventory.add("Sword"); //adds "sword" to the inventory
                                blacksmithShop(); //repeats method
			}
			else{
				System.out.println("Blacksmith: Hello there, stranger. So your name is " + playerName + "? Sorry but i can't make you a weapon unless you bring me some Titanium"); //npc asks player to find titanium
				blacksmithShop(); //repeats method
			}
			
		}
		else if(option==2){ //checks to see if code is to be run
			playerHealth = playerHealth-1; //removes one health point from the player's health pool
                        if (playerHealth < 1){ //checks to see if the player still has health points. If they have 0 or less the game ends
                            dead(); //go to game end screen
                        }
                        else{
			System.out.println("Blacksmith: Hey! Get away from me"); //npc talks to player
                        System.out.println("<You took 1 damange>"); //log-message informing player that he/she has lost a health point
                        System.out.println("<You stopped attacking the blacksmith>"); //log-message informing player that their action has stopped
			System.out.println("Your HP: " + playerHealth); //shows new value of player health
			blacksmithShop(); //repeats method
                        }
		}
		else if(option==3){ //checks to see if code is to be run
			town(); //goes back to town location
		}	
		else{
			blacksmithShop(); //repeats method if wrong value is entered
		}
	}
        
        public void bar(){ //bar location
		System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");
		System.out.println("You relax at the bar and have a drink"); //description of game for player
		System.out.println("<You recover health>"); //log-message telling player their health has increased
		playerHealth = playerHealth + 1; //adding 1 health point to the current player health
		System.out.println("Your HP: " + playerHealth); //informs player of new health point value
		System.out.println("1: Go back"); //option 1
		System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");
		
		option = playersChoice.nextInt(); //uses "playersChoice" scanner to take input from the player and selects the path they chose
		
		if(option==1){ //checks to see if code is to be run
			town(); //goes back to town location
		}
		else{
			bar(); //repeats method if wrong value is entered
		}
	}
	public void east(){ //east location
		System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");
		System.out.println("You walked into a forest and found an Apple"); //description of game for player
                System.out.println("<Apple added to inventory>"); //log-message that apple has been added to inventory
		playerInventory.add("Apple"); //adds apple to the inventory
		System.out.println("1: Go back to the center of Sanity Island"); //option 1
		System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");
		
		option = playersChoice.nextInt(); //uses "playersChoice" scanner to take input from the player and selects the path they chose
		
		if(option==1){ //checks to see if code is to be run
			sanityIsland(); //goes back to sanity island location
		}
		else{
			east(); //repeats method if wrong value is entered
		}
	}
	

	
	
	public void battle(){ //code that simulates the battle between "Aggressive Echidna" and the player
            
		int playerDamage =0; //variable for player damage 		
	        playerDamage = new java.util.Random().nextInt(8); //random integer generator for player damage
		
		System.out.println("You attacked the monster and gave " + playerDamage + " damage!"); //message to the player that they have done a random amount of damage to the monster	
		monsterHealth = monsterHealth - playerDamage; //takes away the random amount of damage from the monster's total health		
		System.out.println("Monster HP: " + monsterHealth); //message to the player of the monster's new total health value
		
		if(monsterHealth<1) //checks to see if monster's health is 0 or less
                { 
                    battleFinish(); //go to battle finish screen
                } 
                else if(monsterHealth>0){  //checks to see if monster's health is greater than 0
			
                int monsterDamage =0; //variable for monster damage		
		monsterDamage = new java.util.Random().nextInt(6); //random integer generator for monster damage
			
		System.out.println("The monster attacked you and gave " + monsterDamage + " damage!"); //message to the player that they have received a random amount of damage from the monster		
		playerHealth = playerHealth - monsterDamage;  //takes away the random amount of damage from the player's total health		
		System.out.println("Player HP: " + playerHealth); //message to the player of the player's new total health value
			
		    if(playerHealth<1) //checks to see if player's health is 0 or less
                    { 
                        dead(); //go to death screen
                    } 
                    else if(playerHealth>0) //checks to see if player's health is 1 or greater
                    {
			north(); //go to north location (where the player can choose to battle again)
		    }
		}
			
	}
	
	public void dead(){ //death screen for player when player has not deployed parachute or has lost all health points
		System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");
		System.out.println("You are dead"); //tells the player they have died
		System.out.println("-GAME OVER-"); //informs the player that the game is over
		System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");
		
	}
	
	public void battleFinish(){ //screen displayed after the battle has been won
		System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");
		System.out.println("You defeated the Aggressive Echinda!"); //description of game for player
		System.out.println("The monster dropped the Master Emerald"); //description of game for player
                playerInventory.add("Master Emerald"); //adds the master emerald into the player's inventory
		System.out.println("<You obtained the Master Emerald>"); //informs player the master emerald is in their inventory
		System.out.println("1: Go back to Sanity Island"); //option1
		System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");
				
		option = playersChoice.nextInt(); //uses "playersChoice" scanner to take input from the player and selects the path they chose
		if(option==1){ //checks to see if code is to be run
			sanityIsland(); //goes back to sanity island location
		}
		else{
			battleFinish(); //repeats method if wrong value is entered
		}
		
	}
	
	public void ending(){ //screen displayed after emerald has been taken to morpheus
		System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");
		System.out.println("Morpheus: Congratulations You can go home!"); //description of game for player
		System.out.println("Morpheus: Thanks you for your service!"); //description of game for player
		System.out.println("\n\n           THE END                    "); //description of game for player
                
                System.out.println("░░░░░░░░░░░░░░░░░░░░░░█████████");
                System.out.println("░░███████░░░░░░░░░░███▒▒▒▒▒▒▒▒███");
                System.out.println("░░█▒▒▒▒▒▒█░░░░░░░███▒▒▒▒▒▒▒▒▒▒▒▒▒███");
                System.out.println("░░░█▒▒▒▒▒▒█░░░░██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██");
                System.out.println("░░░░█▒▒▒▒▒█░░░██▒▒▒▒▒██▒▒▒▒▒▒██▒▒▒▒▒███");
                System.out.println("░░░░░█▒▒▒█░░░█▒▒▒▒▒▒████▒▒▒▒████▒▒▒▒▒▒██");
                System.out.println("░░░█████████████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██");
                System.out.println("░░░█▒▒▒▒▒▒▒▒▒▒▒▒█▒▒▒▒▒▒▒▒▒█▒▒▒▒▒▒▒▒▒▒▒██");
                System.out.println("░██▒▒▒▒▒▒▒▒▒▒▒▒▒█▒▒▒██▒▒▒▒▒▒▒▒▒▒██▒▒▒▒██");
                System.out.println("██▒▒▒███████████▒▒▒▒▒██▒▒▒▒▒▒▒▒██▒▒▒▒▒██");
                System.out.println("█▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒█▒▒▒▒▒▒████████▒▒▒▒▒▒▒██");
                System.out.println("██▒▒▒▒▒▒▒▒▒▒▒▒▒▒█▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██");
                System.out.println("░█▒▒▒███████████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██");
                System.out.println("░██▒▒▒▒▒▒▒▒▒▒████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒█");
                System.out.println("░░████████████░░░█████████████████");
		System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");
               
	}
        
        public void quitGame(){ //quit game screen (if player decides to quit at newgame()
		System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");
		System.out.println("Game Quit"); //description of game for player
		System.out.println("Would you like to start again?"); //asks player for input
                System.out.println("1: Yes"); //option 1
		System.out.println("2: No"); //option 2
		System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");
                
                option = playersChoice.nextInt(); //uses "playersChoice" scanner to take input from the player and selects the path they chose
		
		if(option==1){ //checks to see if code is to be run
			newGame(); //goes to new game screen
		}
		else if(option==2){ //checks to see if code is to be run
			System.exit(0); //ends runtime
		}
                else{
			quitGame(); //repeats method if wrong value is entered
		}
	}
                
}

