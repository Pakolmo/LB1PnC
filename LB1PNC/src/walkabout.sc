;;; Sierra Script 1.0 - (do not remove this comment)
(script# 381)
(include game.sh)
(use Main)
(use Intrface)
(use Path)
(use Avoider)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	walkabout 0
)
(synonyms
	(butler person fellow)
)

(local
	theGJeevesX = [0 0 0 0 100 174 167 163 205 163 260 130 0 0 0 0 260 130 70 170 0 0 0 0 114 124 80 170 20 47 100 168]
	local36 = [0 0 0 0 -20 140 340 163 340 163 340 130 0 0 140 125 140 125 140 240 0 0 0 0 111 124 -20 170 -40 47 -20 168]
	local72 = [0 0 0 0 -20 176 -20 161 -20 150 154 144 0 0 0 0 303 101 0 0 0 0 0 0 0 0 340 175 80 47 340 168]
	local108 = [53 12 4 10 3 9 58 58 9 13 69 69 13 21 22 23 12 35]
	room9aPts = [
		32 152
		66 124
		114 124
		PATHEND
		]
	room9bPts = [
		66 124
		32 162
		340 162
		PATHEND
		]
	room23Pts = [
		66 143
		64 174
		-20 174
		PATHEND
		]
	temp7
)
(instance walkabout of Region
	
	(method (init &tmp [temp0 50])
		(super init:)
;;;		(|= global195 $0400)
		(= global195 (| global195 $0400))
		(Load SCRIPT AVOIDER)
		(Load SCRIPT PATH)
		(if (== [global368 2] 0) (= [global368 2] 1800))
		(Jeeves
			setAvoider: ((Avoider new:) offScreenOK: TRUE)
			setCycle: Walk
			loop: 1
			init:
			hide:
		)
		(= gMyMusic 0)
		(if
			(and
				(== [local108 (- 17 global155)] curRoomNum)
				(> [global368 2] (* (- 16 global155) 100))
			)
			(if gJeevesX
				(= [theGJeevesX (* global155 2)] gJeevesX)
				(= [theGJeevesX (+ (* global155 2) 1)] gJeevesY)
			)
			(Jeeves
				posn: [theGJeevesX (* global155 2)] [theGJeevesX (+ (* global155 2) 1)]
				show:
			)
			(self setScript: walkThru)
		)
	)
	
	(method (doit &tmp [temp0 50])
		(if
			(and
				(== (mod [global368 2] 100) 0)
				(== [local108 (/ [global368 2] 100)] curRoomNum)
			)
			(= global155 (- (- 18 (/ [global368 2] 100)) 1))
			(if
				(and
					(not (& (ego onControl: FALSE) cRED))
					(== global155 8)
				)
				(self setScript: outTheDoor)
			else
				(Jeeves
					posn: [local36 (* global155 2)] [local36 (+ (* global155 2) 1)]
					show:
				)
				(if (== curRoomNum 23) (= [local72 (* global155 2)] 0))
				(self setScript: walkThru)
			)
		)
		(super doit:)
	)
	
	(method (dispose)
		(if script
			(= gJeevesX (Jeeves x?))
			(= gJeevesY (Jeeves y?))
		else
			(= gJeevesX 0)
			(= gJeevesY 0)
		)
		(super dispose:)
		(DisposeScript AVOIDER)
		(DisposeScript PATH)
	)
	
	(method (handleEvent event &tmp temp0)
		
		
		(cond
			(
				(and
					(== (event type?) evMOUSEBUTTON)
					(not (& (event modifiers?) emRIGHT_BUTTON))
				)
				
				(if (ClickedOnObj Jeeves (event x?) (event y?)) 
					
					(event claimed: TRUE)
					(switch theCursor	
						
					
					(602 ;necklace_
						(DoVerb {tell jeeves about necklace})						
					)
					(604 ;monocle
						(DoVerb {tell jeeves about monocle})						
					)
					
					(613 ;lantern_
						(DoVerb {tell jeeves about lantern})						
					)
					(611 ;oilcan_
						(DoVerb {tell jeeves about oilcan})						
					)
					(626 ;rolling_pin_
						(DoVerb {tell jeeves about pin})						
					)
					(620 ;skeleton_key_
						(DoVerb {tell jeeves about skeleton key})						
					)
					(627 ;poker_
						(DoVerb {tell jeeves about poker})						
					)															
					(607 ;crowbar_
						(DoVerb {tell jeeves about crowbar})						
					)
					(628 ;cigar_butt_
						(DoVerb {tell jeeves about butt})						
					)
					(625 ;broken_record_
						(DoVerb {tell jeeves about broken record})						
					)
					(601 ;notebook___pencil_
						(DoVerb {tell jeeves about notebook})						
					)
					(603 ;_7_crackers________
						(DoVerb {tell jeeves about crackers})						
					)
					(605 ;soup_bone_
						(DoVerb {tell jeeves about soup bone})						
					)
					(606 ;valve_handle_
						(DoVerb {tell jeeves about valve})						
					)
					(618 ;bullet_
						(DoVerb {tell jeeves about bullet})						
					)
					(617 ;derringer__
						(DoVerb {tell jeeves about derringer})						
					)
					(614 ;matches_
						(DoVerb {tell jeeves about matches})						
					)
					(615 ;carrot_
						(DoVerb {tell jeeves about carrot})						
					)
					(619 ;brass_key_
						(DoVerb {tell jeeves about brass key})						
					)
					(616 ;diary_
						(DoVerb {tell jeeves about diary})						
					)
					(621 ;crank_
						(DoVerb {tell jeeves about crank})						
					)
					(612 ;cane_
						(DoVerb {tell jeeves about cane})						
					)
					(622 ;pouch_
						(DoVerb {tell jeeves about pouch})						
					)																																																																																
					(630 ;handkerchief_
						(DoVerb {tell jeeves about handkerchief})
					)
											
						
							(994  ;ear
								(event type: 1 claimed: 1)
								(DoVerb {hear gertie})
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
								(DoVerb {ask jeeves about gertrude})
							)
							(2
								(DoVerb {tell jeeves about gertrude})
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
								(DoVerb {ask jeeves about Celie})
							)
							(2
								(DoVerb {tell jeeves about Celie})
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
								(DoVerb {ask jeeves about gloria})
							)
							(2
								(DoVerb {tell jeeves about gloria})
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
								(DoVerb {ask jeeves about ethel})
							)
							(2
								(DoVerb {tell jeeves about ethel})
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
								(DoVerb {ask jeeves about fifi})
							)
							(2
								(DoVerb {tell jeeves about fifi})
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
								(DoVerb {ask jeeves about lillian})
							)
							(2
								(DoVerb {tell jeeves about lillian})
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
								(DoVerb {ask jeeves about Clarence})
							)
							(2
								(DoVerb {tell jeeves about clarence})
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
								(DoVerb {ask jeeves about Wilbur})
							)
							(2
								(DoVerb {tell jeeves about Wilbur})
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
								(DoVerb {ask jeeves about rudolph})
							)
							(2
								(DoVerb {tell jeeves about rudolph})
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
								(DoVerb {ask jeeves about colonel})
							)
							(2
								(DoVerb {tell jeeves about colonel})
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
								(DoVerb {ask jeeves about Jules})
							)
							(2
								(DoVerb {tell jeeves about Jules})
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
								(DoVerb {ask jeeves about beauregard})
							)
							(2
								(DoVerb {tell jeeves about beauregard})
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
								(DoVerb {ask jeeves about polly})
							)
							(2
								(DoVerb {tell jeeves about polly})
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
								(DoVerb {ask jeeves about blaze})
							)
							(2
								(DoVerb {tell jeeves about blaze})
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
							(DoVerb {converse jeeves})	
						)	
						(else
						
							(event claimed: FALSE)
						)
					)

				)
			)
						)		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		(return (if (event claimed?) (return TRUE) else FALSE))
	)
)

(instance walkThru of Script

	(method (changeState newState &tmp [temp0 50])
		(switch (= state newState)
			(0
				(Jeeves show:)
				(if (== [local72 (* global155 2)] 0)
					(cond 
						((and (== curRoomNum 9) (== global155 9))
							(Jeeves setMotion: room9a self)
						)
						((and (== curRoomNum 9) (== global155 12))
							(Jeeves setMotion: room9b self)
						)
						((== curRoomNum 23)
							(Jeeves setMotion: room23 self)
						)
					)
				else
					(Jeeves
						setMotion:
							MoveTo
							[local72 (* global155 2)]
							[local72 (+ (* global155 2) 1)]
							self
					)
				)
			)
			(1
				(if (== global155 5)
					(if (== (gDoor cel?) 0)
						(HandsOff)
						(gDoor cycleSpeed: 3 setCycle: EndLoop self)
						(gMySound number: 107 play:)
					else
						(= state 0)
						(= cycles 1)
					)
				else
					(++ global155)
					(= [global368 2] (- 1700 (* global155 100)))
					(Jeeves hide:)
					(client setScript: 0)
				)
			)
			(2
				(HandsOn)
				(Jeeves setPri: 2 setMotion: MoveTo 140 125 self)
			)
			(3
				(gDoor cycleSpeed: 3 setCycle: BegLoop self)
				(gMySound number: 107 play:)
			)
			(4
				(++ global155)
				(= [global368 2] (- 1700 (* global155 100)))
				(gDoor stopUpd:)
				(Jeeves setPri: -1 hide:)
				(client setScript: 0)
			)
		)
	)
)

(instance outTheDoor of Script
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gDoor cycleSpeed: 3 setCycle: EndLoop self)
				(gMySound number: 107 play:)
				(Jeeves show: posn: 140 125 setPri: 2 loop: 2)
			)
			(1
				(Jeeves setPri: -1 setMotion: MoveTo 164 144 self)
			)
			(2
				(HandsOn)
				(Jeeves setMotion: MoveTo 303 101 self)
				(gDoor setCycle: BegLoop)
				(gMySound number: 108 play:)
			)
			(3
				(gDoor stopUpd:)
				(++ global155)
				(= [global368 2] (- 1700 (* global155 100)))
				(Jeeves setPri: -1 hide:)
				(client setScript: 0)
			)
		)
	)
)

(instance Jeeves of Actor
	(properties
		y 131
		x 286
		view 440
	)
	
	(method (handleEvent event)
		(= theTalker talkJEEVES)
		(cond 
			((or (MousedOn self event shiftDown) (Said 'examine/butler'))
				(event claimed: TRUE)
				(if (& global207 $0400)
					(Print 381 0)
				else
;;;					(|= global207 $0400)
					(= global207 (| global207 $0400))
					(Say 0 381 1)
				)
				(event claimed: TRUE)
			)
			((Said 'flirt//butler<with')
				(Print 381 2)
			)
			((Said 'ask,tell//*<about')
				(Print 381 3)
			)
			((Said 'hold,deliver/*')
				(if (and theInvItem haveInvItem)
					(Print 381 4)
				else
					(DontHave)
				)
			)
			((Said '/butler>')
				(cond 
					((Said 'converse')
						(Print 381 3)
					)
					((Said 'get')
						(Print 381 5)
					)
					((Said 'kill')
						(Print 381 6)
					)
					((Said 'kiss')
						(Print 381 7)
					)
					((Said 'embrace')
						(Print 381 8)
					)
				)
			)
		)
	)
)

(instance room9a of Path
	
	(method (at n)
		(return [room9aPts n])
	)
)

(instance room9b of Path
	
	(method (at n)
		(return [room9bPts n])
	)
)

(instance room23 of Path

	(method (at n)
		(return [room23Pts n])
	)
)
