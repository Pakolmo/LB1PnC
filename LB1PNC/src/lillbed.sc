;;; Sierra Script 1.0 - (do not remove this comment)
(script# 265) ;OK
(include game.sh)
(use Main)
(use Intrface)
(use Game)
(use Actor)

(public
	lillbed 0
)

(local
	local0
	talkCount
	temp7
)
(instance lillbed of Region
	
	(method (init)
		(super init:)
		(Load FONT 4)
		(Lillian setPri: 11 init:)
		(= theTalker talkLILLIAN)
	)
	
	(method (doit)
		(super doit:)
	)
	
	(method (dispose)
		(super dispose:)
	)
	
	(method (handleEvent event)
		
						(cond
			(
				(and
					(== (event type?) evMOUSEBUTTON)
					(not (& (event modifiers?) emRIGHT_BUTTON))
				)
				
			(if (ClickedOnObj Lillian (event x?) (event y?)) 
					
					(event claimed: TRUE)
					(switch theCursor	
					
					(602 ;necklace_
						(DoVerb {tell lillian about necklace})						
					)
					(604 ;monocle
						(DoVerb {tell lillian about monocle})						
					)
					
					(613 ;lantern_
						(DoVerb {tell lillian about lantern})						
					)
					(611 ;oilcan_
						(DoVerb {tell lillian about oilcan})						
					)
					(626 ;rolling_pin_
						(DoVerb {tell lillian about pin})						
					)
					(620 ;skeleton_key_
						(DoVerb {tell lillian about skeleton key})						
					)
					(627 ;poker_
						(DoVerb {tell lillian about poker})						
					)															
					(607 ;crowbar_
						(DoVerb {tell lillian about crowbar})						
					)
					(628 ;cigar_butt_
						(DoVerb {tell lillian about butt})						
					)
					(625 ;broken_record_
						(DoVerb {tell lillian about broken record})						
					)
					(601 ;notebook___pencil_
						(DoVerb {tell lillian about notebook})						
					)
					(603 ;_7_crackers________
						(DoVerb {tell lillian about crackers})						
					)
					(605 ;soup_bone_
						(DoVerb {tell lillian about soup bone})						
					)
					(606 ;valve_handle_
						(DoVerb {tell lillian about valve})						
					)
					(618 ;bullet_
						(DoVerb {tell lillian about bullet})						
					)
					(617 ;derringer__
						(DoVerb {tell lillian about derringer})						
					)
					(614 ;matches_
						(DoVerb {tell lillian about matches})						
					)
					(615 ;carrot_
						(DoVerb {tell lillian about carrot})						
					)
					(619 ;brass_key_
						(DoVerb {tell lillian about brass key})						
					)
					(616 ;diary_
						(DoVerb {tell lillian about diary})						
					)
					(621 ;crank_
						(DoVerb {tell lillian about crank})						
					)
					(612 ;cane_
						(DoVerb {tell lillian about cane})						
					)
					(622 ;pouch_
						(DoVerb {tell lillian about pouch})						
					)																																																																																
					(630 ;handkerchief_
						(DoVerb {tell lillian about handkerchief})
					)
											
						
						
						
						
							(930  ;gertrude
								(event type: 1 claimed: 1)
								(DoVerb {ask lillian about Gertrude})
							)
							(931 ;Celie
								(event type: 1 claimed: 1)
								(DoVerb {ask lillian about Celie})
							)	
							(932 ;Gloria
								(event type: 1 claimed: 1)
								(DoVerb {ask lillian about Gloria})
							)													
							(933 ;Ethel
								(event type: 1 claimed: 1)
								(DoVerb {ask lillian about Ethel})
							)	
							(934 ;Fifi
								(event type: 1 claimed: 1)
								(DoVerb {ask lillian about Fifi})
							)	
							(935 ;Lillian
								(event type: 1 claimed: 1)
								(DoVerb {ask lillian about Lillian})
							)																					
							(936 ;Clarence
								(event type: 1 claimed: 1)
								(DoVerb {ask lillian about Clarence})
							)	
							(937 ;Feels
								(event type: 1 claimed: 1)
								(DoVerb {ask lillian about Wilbur})
							)
							(938 ;Rudy
								(event type: 1 claimed: 1)
								(DoVerb {ask lillian about Rudy})
							)	
							(939 ;Colonel
								(event type: 1 claimed: 1)
								(DoVerb {ask lillian about Colonel})
							)
							(940 ;Jules
								(event type: 1 claimed: 1)
								(DoVerb {ask lillian about Jules})
							)
							(941 ;Dog
								(event type: 1 claimed: 1)
								(DoVerb {ask lillian about beauregard})
							)													
							(942 ;Parrot
								(event type: 1 claimed: 1)
								(DoVerb {ask lillian about polly})
							)							
							(943 ;Horse
								(event type: 1 claimed: 1)
								(DoVerb {ask lillian about blaze})
							)							
													
							
							
							
							
														
						(996 ;talk
							(DoVerb {converse lillian})
						)
						(998	
							(DoVerb {Examine lillian})
						)
						(995
							(= temp7
												(Print
													{Lillian}
													#button {Coger} 1
													#button {Matar} 2								
													#button {Besar} 3
													#button {Abrazar} 4
												)
											)
											(switch temp7
												(1 
													(DoVerb {get lillian})
												)
												(2 
													(DoVerb {kill lillian})
												)		
												(3 
													(DoVerb {kiss lillian})
												)		
												(4 
													(DoVerb {embrace lillian})
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
				
				
				
				



		
		
		
		
		
		
		
		
		
		
		
		
		
		
		(= theTalker talkLILLIAN)
		(super handleEvent: event)
		(if (event claimed?) (return TRUE))
		(return
			(cond 
				((Said 'converse[/lil]')
					(switch talkCount
						(0
							(Say 1 265 0)
							(Say 1 265 1)
						)
						(1
							(Say 1 265 2)
						)
						(2
							(Say 1 265 3)
						)
						(else
							(Print 265 4)
						)
					)
					(++ talkCount)
				)
				((Said 'hear/lil')
					(Print 265 5)
				)
				((Said 'ask,tell,deliver,hold')
					(Say 1 265 6)
				)
				((Said 'get/lil')
					(Print 265 7)
				)
				((Said 'kill/lil')
					(Print 265 8)
				)
				((Said 'kiss/lil')
					(Print 265 9)
				)
				((Said 'embrace/lil')
					(Print 265 10)
				)
			)
		)
	)
)

(instance Lillian of Actor
	(properties
		y 134
		x 285
		view 514
		loop 1
		illegalBits $0000
	)
	
	(method (handleEvent event)
		(= theTalker talkLILLIAN)
		(if (or (MousedOn self event shiftDown) (Said 'examine/lil'))
			(if (& global207 $0020)
				(Print 265 11)
			else
				(|= global207 $0020)
				(Print 265 12)
			)
			(event claimed: TRUE)
		)
	)
)

;;;(instance lHead of Prop
;;;	(properties
;;;		y 133
;;;		x 265
;;;		view 512
;;;		loop 4
;;;	)
;;;)
