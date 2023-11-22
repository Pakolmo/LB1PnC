;;; Sierra Script 1.0 - (do not remove this comment)
(script# 204)
(include game.sh)
(use Main)
(use Intrface)
(use Motion)
(use Actor)

(local
	temp7
	
)
(class servent of Actor
	(properties
		guest1 0
		exitX 0
		exitY 0
		seconds 0
		lastSeconds 0
		serveState 0
		guestState 0
		serving 0
		outOfRoom 0
		itemX 0
		itemY 0
	)
	
	(method (init)
		(super init:)
		(Load FONT 4)
		(= serveState -1)
		(= guestState 1)
		(= serving 0)
		(|= global195 $0400)
		(= global195 (| global195 $0400))		
	)
	
	(method (doit &tmp oldSeconds)
		(super doit:)
		(if
			(and
				seconds
				(!= lastSeconds (= oldSeconds (GetTime SYSTIME1)))
			)
			(= lastSeconds oldSeconds)
			(if (not (-- seconds))
				(self cue:)
			)
		)
		(if (and (== global167 1) (== serving 0))
			(self serve:)
			(= serving TRUE)
		)
	)
	
	(method (dispose)
		(DisposeScript AVOIDER)
		(= global195 (& global195 $fbff))
		(super dispose:)
	)
	
	(method (handleEvent event &tmp temp0)
		
		
	
		(cond
			(
				(and
					(== (event type?) evMOUSEBUTTON)
					(not (& (event modifiers?) emRIGHT_BUTTON))
				)
				
				(if (ClickedOnObj servent (event x?) (event y?)) 
					
					(event claimed: TRUE)
					(switch theCursor	
						
					
					(602 ;necklace_
						(DoVerb {tell butler about necklace})						
					)
					(604 ;monocle
						(DoVerb {tell butler about monocle})						
					)
					
					(613 ;lantern_
						(DoVerb {tell butler about lantern})						
					)
					(611 ;oilcan_
						(DoVerb {tell butler about oilcan})						
					)
					(626 ;rolling_pin_
						(DoVerb {tell butler about pin})						
					)
					(620 ;skeleton_key_
						(DoVerb {tell butler about skeleton key})						
					)
					(627 ;poker_
						(DoVerb {tell butler about poker})						
					)															
					(607 ;crowbar_
						(DoVerb {tell butler about crowbar})						
					)
					(628 ;cigar_butt_
						(DoVerb {tell butler about butt})						
					)
					(625 ;broken_record_
						(DoVerb {tell butler about broken record})						
					)
					(601 ;notebook___pencil_
						(DoVerb {tell butler about notebook})						
					)
					(603 ;_7_crackers________
						(DoVerb {tell butler about crackers})						
					)
					(605 ;soup_bone_
						(DoVerb {tell butler about soup bone})						
					)
					(606 ;valve_handle_
						(DoVerb {tell butler about valve})						
					)
					(618 ;bullet_
						(DoVerb {tell butler about bullet})						
					)
					(617 ;derringer__
						(DoVerb {tell butler about derringer})						
					)
					(614 ;matches_
						(DoVerb {tell butler about matches})						
					)
					(615 ;carrot_
						(DoVerb {tell butler about carrot})						
					)
					(619 ;brass_key_
						(DoVerb {tell butler about brass key})						
					)
					(616 ;diary_
						(DoVerb {tell butler about diary})						
					)
					(621 ;crank_
						(DoVerb {tell butler about crank})						
					)
					(612 ;cane_
						(DoVerb {tell butler about cane})						
					)
					(622 ;pouch_
						(DoVerb {tell butler about pouch})						
					)																																																																																
					(630 ;handkerchief_
						(DoVerb {tell butler about handkerchief})
					)
											
						
							(994  ;ear
								(event type: 1 claimed: 1)
								(DoVerb {hear jeeves})
							)						
						
				
						
							(930  ;gertrude
								(event type: 1 claimed: 1)
												(= temp7
							(Print
;;;								{Ask or Tell}
;;;								#button {Ask} 1
;;;								#button {Tell} 2
								{Preguntar o Hablar de}
								#button {Preguntar} 1
								#button {Hablar de} 2												
							)
						)
						(switch temp7
							(1 
								(DoVerb {ask butler about gertrude})
							)
							(2
								(DoVerb {tell butler about gertrude})
							)
						(else
							(event claimed: FALSE)
						)
					)
				)
							
							(931 ;Celie
								(event type: 1 claimed: 1)
								(= temp7
															(Print
;;;								{Ask or Tell}
;;;								#button {Ask} 1
;;;								#button {Tell} 2
								{Preguntar o Hablar de}
								#button {Preguntar} 1
								#button {Hablar de} 2												
							)
						)
						(switch temp7
							(1 
								(DoVerb {ask butler about Celie})
							)
							(2
								(DoVerb {tell butler about Celie})
							)
						(else
							(event claimed: FALSE)
						)
					)
				)
							
							(932 ;Gloria
								(event type: 1 claimed: 1)
								(= temp7
															(Print
;;;								{Ask or Tell}
;;;								#button {Ask} 1
;;;								#button {Tell} 2
								{Preguntar o Hablar de}
								#button {Preguntar} 1
								#button {Hablar de} 2												
							)
						)
						(switch temp7
							(1 
								(DoVerb {ask butler about gloria})
							)
							(2
								(DoVerb {tell butler about gloria})
							)
						(else
							(event claimed: FALSE)
						)
					)
				)												
							(933 ;Ethel
								
								(event type: 1 claimed: 1)
								(= temp7
															(Print
;;;								{Ask or Tell}
;;;								#button {Ask} 1
;;;								#button {Tell} 2
								{Preguntar o Hablar de}
								#button {Preguntar} 1
								#button {Hablar de} 2												
							)
						)
						(switch temp7
							(1 
								(DoVerb {ask butler about ethel})
							)
							(2
								(DoVerb {tell butler about ethel})
							)
						(else
							(event claimed: FALSE)
						)
					)
				)
							
							(934 ;Fifi
								(event type: 1 claimed: 1)
								(= temp7
														(Print
;;;								{Ask or Tell}
;;;								#button {Ask} 1
;;;								#button {Tell} 2
								{Preguntar o Hablar de}
								#button {Preguntar} 1
								#button {Hablar de} 2												
							)
						)
						(switch temp7
							(1 
								(DoVerb {ask butler about fifi})
							)
							(2
								(DoVerb {tell butler about fifi})
							)
						(else
							(event claimed: FALSE)
						)
					)
				)
							(935 ;Lillian
								(event type: 1 claimed: 1)
								(= temp7
															(Print
;;;								{Ask or Tell}
;;;								#button {Ask} 1
;;;								#button {Tell} 2
								{Preguntar o Hablar de}
								#button {Preguntar} 1
								#button {Hablar de} 2												
							)
						)
						(switch temp7
							(1 
								(DoVerb {ask butler about lillian})
							)
							(2
								(DoVerb {tell butler about lillian})
							)
						(else
							(event claimed: FALSE)
						)
					)
				)																				
							(936 ;Clarence
								(event type: 1 claimed: 1)
								(= temp7
															(Print
;;;								{Ask or Tell}
;;;								#button {Ask} 1
;;;								#button {Tell} 2
								{Preguntar o Hablar de}
								#button {Preguntar} 1
								#button {Hablar de} 2												
							)
						)
						(switch temp7
							(1 
								(DoVerb {ask butler about Clarence})
							)
							(2
								(DoVerb {tell butler about clarence})
							)
						(else
							(event claimed: FALSE)
						)
					)
				)
							(937 ;Feels
								(event type: 1 claimed: 1)
								(= temp7
															(Print
;;;								{Ask or Tell}
;;;								#button {Ask} 1
;;;								#button {Tell} 2
								{Preguntar o Hablar de}
								#button {Preguntar} 1
								#button {Hablar de} 2												
							)
						)
						(switch temp7
							(1 
								(DoVerb {ask butler about Wilbur})
							)
							(2
								(DoVerb {tell butler about Wilbur})
							)
						(else
							(event claimed: FALSE)
						)
					)
				)
							(938 ;Rudy
								(event type: 1 claimed: 1)
								(= temp7
															(Print
;;;								{Ask or Tell}
;;;								#button {Ask} 1
;;;								#button {Tell} 2
								{Preguntar o Hablar de}
								#button {Preguntar} 1
								#button {Hablar de} 2												
							)
						)
						(switch temp7
							(1 
								(DoVerb {ask butler about rudolph})
							)
							(2
								(DoVerb {tell butler about rudolph})
							)
						(else
							(event claimed: FALSE)
						)
					)
				)
							(939 ;Colonel
								(event type: 1 claimed: 1)
								(= temp7
															(Print
;;;								{Ask or Tell}
;;;								#button {Ask} 1
;;;								#button {Tell} 2
								{Preguntar o Hablar de}
								#button {Preguntar} 1
								#button {Hablar de} 2												
							)
						)
						(switch temp7
							(1 
								(DoVerb {ask butler about colonel})
							)
							(2
								(DoVerb {tell butler about colonel})
							)
						(else
							(event claimed: FALSE)
						)
					)
				)
							(940 ;Jules
								(event type: 1 claimed: 1)
								(= temp7
															(Print
;;;								{Ask or Tell}
;;;								#button {Ask} 1
;;;								#button {Tell} 2
								{Preguntar o Hablar de}
								#button {Preguntar} 1
								#button {Hablar de} 2												
							)
						)
						(switch temp7
							(1 
								(DoVerb {ask butler about Jeeves})
							)
							(2
								(DoVerb {tell butler about Jeeves})
							)
						(else
							(event claimed: FALSE)
						)
					)
				)
		
							(941 ;Dog
								(event type: 1 claimed: 1)
							(= temp7	
							(Print
;;;								{Ask or Tell}
;;;								#button {Ask} 1
;;;								#button {Tell} 2
								{Preguntar o Hablar de}
								#button {Preguntar} 1
								#button {Hablar de} 2												
							)
						)
						(switch temp7
							(1 
								(DoVerb {ask butler about beauregard})
							)
							(2
								(DoVerb {tell butler about beauregard})
							)
						(else
							(event claimed: FALSE)
						)
					)
				)												
							(942 ;Parrot
								(event type: 1 claimed: 1)
								(= temp7	
							(Print
;;;								{Ask or Tell}
;;;								#button {Ask} 1
;;;								#button {Tell} 2
								{Preguntar o Hablar de}
								#button {Preguntar} 1
								#button {Hablar de} 2												
							)
						)
						(switch temp7
							(1 
								(DoVerb {ask butler about polly})
							)
							(2
								(DoVerb {tell butler about polly})
							)
						(else
							(event claimed: FALSE)
						)
					)
				)				
							(943 ;Horse
								(event type: 1 claimed: 1)
								(= temp7	
							(Print
;;;								{Ask or Tell}
;;;								#button {Ask} 1
;;;								#button {Tell} 2
								{Preguntar o Hablar de}
								#button {Preguntar} 1
								#button {Hablar de} 2												
							)
						)
						(switch temp7
							(1 
								(DoVerb {ask butler about blaze})
							)
							(2
								(DoVerb {tell butler about blaze})
							)
						(else
							(event claimed: FALSE)
						)
					)
				)								
							
										
						(998		
							(DoVerb {examine butler})
						)
						(996
							(= temp7	
							(Print
;;;								{Converse or Drink}
;;;								#button {Converse} 1
;;;								#button {Drink} 2
								{Conversar o Pedir copa}
								#button {Conversar} 1
								#button {Pedir copa} 2												
							)
						)
						(switch temp7
							(1 
								(DoVerb {converse butler})
							)
							(2
								(DoVerb {get drink})
							)
						(else
							(event claimed: FALSE)
						)
					)
				)					
							
						(else
						
							(event claimed: FALSE)
						)
					)

				)
			)
						)		
		
		
					
		
		
		
		
		
		
		
		
		
		(if (event claimed?) (return))
		(if
			(and
				(== (event type?) saidEvent)
				(self inRect: 0 0 319 191)
			)
			(cond 
				(
					(or
						(MousedOn self event shiftDown)
						(Said 'examine/butler,fellow')
					)
					(if (& global207 $0400)
						(Print 204 0)
					else
						(= theTalker talkJEEVES)
;;;						(|= global207 $0400)
						(= global207 (| global207 $0400))						
						(Say 0 204 1)
					)
					(event claimed: TRUE)
				)
				((Said 'flirt//(butler,fellow)<with')
					(Print 204 2)
				)
				((Said 'ask,get/drink,glass')
					(Print 204 3)
				)
				((Said 'ask,tell[/butler]/*<about')
					(Print 204 4)
				)
				(
					(or
						(Said 'deliver,hold/*/butler')
						(Said 'deliver,hold/*<butler')
					)
					(if (and theInvItem haveInvItem)
						(Print 204 4)
					else
						(DontHave)
					)
				)
				((Said 'examine/people')
					(Printf 204 5
						(switch curRoomNum
							(32 {Wilbur})
							(36 {Gloria})
							(38 {Clarence})
							(48 {Rudy})
						)
					)
				)
				((Said 'examine/men')
					(Printf 204 5
						(switch curRoomNum
							(32 {Wilbur})
							(38 {Clarence})
							(48 {Rudy})
							(else
								(event claimed: FALSE)
							)
						)
					)
				)
				((Said '/butler,fellow>')
					(cond 
						((Said 'converse')
							(Print 204 4)
						)
						((Said 'get')
							(Print 204 6)
						)
						((Said 'kill')
							(Print 204 7)
						)
						((Said 'embrace')
							(Print 204 8)
						)
						((Said 'kiss')
							(Print 204 9)
						)
					)
				)
			)
		)
	)
	
	(method (cue)
		(switch (++ serveState)
			(0
				(self loop: 3)
				(Print 204 10 #at 160 10 #font 4 #draw #dispose)
				(self converse:)
			)
			(1
				(cls)
				(Print 204 11 #at 160 10 #font 4 #draw #dispose)
				(self converse:)
			)
			(2
				(cls)
				(= serveState -1)
				(self leave:)
			)
			(3
				(if (== outOfRoom TRUE)
					(self setAvoider: 0 stopUpd: dispose:)
				)
			)
		)
	)
	
	(method (serve)
		(self setMotion: MoveTo itemX itemY self)
	)
	
	(method (leave)
		(= serveState 2)
		(= outOfRoom TRUE)
		(self setMotion: MoveTo exitX exitY self)
	)
	
	(method (converse)
		(= seconds 3)
	)
)
