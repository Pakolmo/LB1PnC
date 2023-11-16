;;; Sierra Script 1.0 - (do not remove this comment)
(script# 267)
(include game.sh)
(use Main)
(use Intrface)
(use Avoider)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	dusting 0
)
(synonyms
	(fifi person girl)
)

(local
	fifiDir
	talkCount
	toXY = [96 145 216 143 165 155 189 104 111 104 34 92]
	local14
	temp7
)
(instance dusting of Region
	
	(method (init)
		(super init:)
		(= global192 1)
		(Load FONT 4)
		(LoadMany 143 243 294)
		(LoadMany VIEW 470 904)
		(= global208 16)
		(= [global377 4] 294)
		(Fifi
			view: 464
			setAvoider: ((Avoider new:) offScreenOK: TRUE)
			init:
			setScript: fifiActions
		)
	)
	
	(method (doit)
		(super doit:)
	)
	
	(method (dispose)
		(DisposeScript AVOIDER)
		(super dispose:)
	)
	
	(method (handleEvent event)
		
		
			(cond
			(
				(and
					(== (event type?) evMOUSEBUTTON)
					(not (& (event modifiers?) emRIGHT_BUTTON))
				)
					(if (ClickedOnObj Fifi (event x?) (event y?)) 
					
					(event claimed: TRUE)
					(switch theCursor	
					
					(602 ;necklace_
						(DoVerb {tell fifi about necklace})						
					)
					(604 ;monocle
						(DoVerb {tell fifi about monocle})						
					)
					
					(613 ;lantern_
						(DoVerb {tell fifi about lantern})						
					)
					(611 ;oilcan_
						(DoVerb {tell fifi about oilcan})						
					)
					(626 ;rolling_pin_
						(DoVerb {tell fifi about pin})						
					)
					(620 ;skeleton_key_
						(DoVerb {tell fifi about skeleton key})						
					)
					(627 ;poker_
						(DoVerb {tell fifi about poker})						
					)															
					(607 ;crowbar_
						(DoVerb {tell fifi about crowbar})						
					)
					(628 ;cigar_butt_
						(DoVerb {tell fifi about butt})						
					)
					(625 ;broken_record_
						(DoVerb {tell fifi about broken record})						
					)
					(601 ;notebook___pencil_
						(DoVerb {tell fifi about notebook})						
					)
					(603 ;_7_crackers________
						(DoVerb {tell fifi about crackers})						
					)
					(605 ;soup_bone_
						(DoVerb {tell fifi about soup bone})						
					)
					(606 ;valve_handle_
						(DoVerb {tell fifi about valve})						
					)
					(618 ;bullet_
						(DoVerb {tell fifi about bullet})						
					)
					(617 ;derringer__
						(DoVerb {tell fifi about derringer})						
					)
					(614 ;matches_
						(DoVerb {tell fifi about matches})						
					)
					(615 ;carrot_
						(DoVerb {tell fifi about carrot})						
					)
					(619 ;brass_key_
						(DoVerb {tell fifi about brass key})						
					)
					(616 ;diary_
						(DoVerb {tell fifi about diary})						
					)
					(621 ;crank_
						(DoVerb {tell fifi about crank})						
					)
					(612 ;cane_
						(DoVerb {tell fifi about cane})						
					)
					(622 ;pouch_
						(DoVerb {tell fifi about pouch})						
					)																																																																																
					(630 ;handkerchief_
						(DoVerb {tell fifi about handkerchief})
					)
											
						
						
						
						
							(930  ;gertrude
								(event type: 1 claimed: 1)
								(DoVerb {ask fifi about Gertrude})
							)
							(931 ;Celie
								(event type: 1 claimed: 1)
								(DoVerb {ask fifi about Celie})
							)	
							(932 ;Gloria
								(event type: 1 claimed: 1)
								(DoVerb {ask fifi about Gloria})
							)													
							(933 ;Ethel
								(event type: 1 claimed: 1)
								(DoVerb {ask fifi about Ethel})
							)	
							(934 ;Fifi
								(event type: 1 claimed: 1)
								(DoVerb {ask fifi about Fifi})
							)	
							(935 ;Lillian
								(event type: 1 claimed: 1)
								(DoVerb {ask fifi about Lillian})
							)																					
							(936 ;Clarence
								(event type: 1 claimed: 1)
								(DoVerb {ask fifi about Clarence})
							)	
							(937 ;Feels
								(event type: 1 claimed: 1)
								(DoVerb {ask fifi about Wilbur})
							)
							(938 ;Rudy
								(event type: 1 claimed: 1)
								(DoVerb {ask fifi about Rudy})
							)	
							(939 ;Colonel
								(event type: 1 claimed: 1)
								(DoVerb {ask fifi about Colonel})
							)
							(940 ;Jules
								(event type: 1 claimed: 1)
								(DoVerb {ask fifi about Jules})
							)
							(941 ;Dog
								(event type: 1 claimed: 1)
								(DoVerb {ask fifi about beauregard})
							)													
							(942 ;Parrot
								(event type: 1 claimed: 1)
								(DoVerb {ask fifi about polly})
							)							
							(943 ;Horse
								(event type: 1 claimed: 1)
								(DoVerb {ask fifi about blaze})
							)							
													
							
							
						(994	
							(DoVerb {hear Fifi})
						)							
						(996 ;talk
							(DoVerb {converse Fifi})
						)
						(998	
							(DoVerb {Examine Fifi})
						)
						(995
							(= temp7
												(Print
													{Fifi}
													#button {Coger} 1
													#button {Matar} 2								
													#button {Besar} 3
													#button {Abrazar} 4
												)
											)
											(switch temp7
												(1 
													(DoVerb {get fifi})
												)
												(2 
													(DoVerb {kill fifi})
												)		
												(3 
													(DoVerb {kiss fifi})
												)		
												(4 
													(DoVerb {embrace fifi})
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
		
		
		
		
		
		
		
		
		(super handleEvent: event)
	)
)

(instance fifiActions of Script
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== fifiDir 3)
					(Fifi setMotion: MoveTo 177 144 self)
				else
					(= cycles 1)
				)
			)
			(1
				(if (== fifiDir 3)
					(Fifi setMotion: MoveTo 170 124 self)
				else
					(= cycles 1)
				)
			)
			(2
				(= local14 0)
				(Fifi
					view: 464
					setCycle: Walk
					ignoreActors: FALSE
					setMotion:
						MoveTo
						[toXY (* fifiDir 2)]
						[toXY (+ (* fifiDir 2) 1)]
						self
				)
			)
			(3
				(Fifi
					view: 470
					cel: 0
					loop:
					(switch fifiDir
						(0 4)
						(1 4)
						(2 5)
						(3 1)
						(4 0)
						(5 1)
					)
					setCycle: EndLoop self
				)
			)
			(4
				(Fifi
					loop:
					(switch fifiDir
						(0 6)
						(1 6)
						(2 7)
						(3 3)
						(4 2)
						(5 3)
					)
					setCycle: Forward
				)
				(= seconds 4)
			)
			(5
				(Fifi
					cel: 2
					loop:
					(switch fifiDir
						(0 4)
						(1 4)
						(2 5)
						(3 1)
						(4 0)
						(5 1)
					)
					setCycle: BegLoop self
				)
			)
			(6
				(Fifi view: 464 setCycle: Walk ignoreActors: FALSE)
				(if (< fifiDir 5)
					(++ fifiDir)
					(= state -1)
				)
				(= cycles 1)
			)
			(7
				(Fifi setMotion: MoveTo -20 98 self)
			)
			(8
				(= global192 2)
				(Fifi dispose:)
			)
		)
	)
)

(instance Fifi of Actor
	(properties
		y 140
		x 196
	)
	
	(method (handleEvent event)
		(cond 
			((and (MousedOn self event shiftDown) (not (& global207 $0010)))
				(event claimed: TRUE)
				(DoLook {fifi})
			)
			(
				(and
					(& global207 $0010)
					(or (MousedOn self event shiftDown) (Said 'examine/fifi'))
				)
				(event claimed: TRUE)
				(Print 267 0)
			)
			((and (== (event type?) saidEvent) (Said '*/fifi>'))
				(cond 
					((Said 'converse')
						(= theTalker talkFIFI)
						(switch talkCount
							(0 (Say 1 267 1))
							(1 (Say 1 267 2))
							(2 (Say 1 267 3))
							(3 (Say 1 267 4))
							(else  (Say 1 267 5))
						)
						(++ talkCount)
					)
					((Said 'hear')
						(Print 267 6)
					)
				)
			)
		)
	)
)
