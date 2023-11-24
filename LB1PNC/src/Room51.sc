;;; Sierra Script 1.0 - (do not remove this comment)
(script# 51) ;OK
(include game.sh)
(use Main)
(use HighLite)
(use Intrface)
(use RFeature)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)
(use User)

(public
	Room51 0
)
(synonyms
	(stair upstair)
	(room room passage)
)

(local
	local0
	temp7
)
(instance glow of HighLite)

(instance Room51 of Room
	(properties
		picture 51
	)
	
	(method (init)
;;;		(HandsOff)
			(User canControl: FALSE canInput: FALSE)

				
				(User mapKeyToDir: FALSE)
			(theGame setCursor: 997 (HaveMouse))
		(= horizon 0)
		(= west 55)
		(= global189 51)
		(super init:)
		(self setRegions: 242 setFeatures: trapdoor)
		(addToPics add: trapdoor eachElementDo: #init doit:)
		(if lanternIsLit
			(if (== prevRoomNum 65)
				(= local0 0)
				(User canControl: FALSE canInput: FALSE)
;;;				(ego setMotion: 0)
				
				(User mapKeyToDir: FALSE)
;;;				(theGame setCursor: 997 (HaveMouse))
				(ego
					loop: 1
					posn: 222 91
					illegalBits: 0
					setMotion: MoveTo 116 170 self
				)
			else
				(= local0 1)
				(ego loop: 0 y: 170)
			)
			
			(ego view: 7 xStep: 3 init:)
			
			(glow deltaX: 8 deltaY: 8 ignoreCast: 1 init:)
			(rat
				view: 151
				setLoop: 3
				setStep: 5 5
				illegalBits: 0
				ignoreActors: TRUE
				posn: 139 171
				setCycle: Walk
				init:
				setScript: Scurry
			)
				(User canControl: TRUE canInput: TRUE)
;;;				(ego setMotion: 0)
				
				(User mapKeyToDir: TRUE)
				(theGame setCursor: 999 (HaveMouse))
		else
			(HandsOff)
			(ego
				view: 49
				loop: 1
				posn: 222 91
				illegalBits: 0
				init:
				setScript: tumble
			)
		)
	)
	
	(method (doit)
		(if (and (FirstEntry) lanternIsLit)
			(Print 51 0)
			
		)
		(if (and (not local0) (< (ego x?) 117))
			(= local0 1)
			(User canControl: FALSE canInput: FALSE)
		)
;;;		(if (and local0 (& (ego onControl: origin) cCYAN))
		(if (and local0 (& (ego onControl: 1) $0008))
;;;			(HandsOff)
			(User canControl: FALSE canInput: FALSE)

				
				(User mapKeyToDir: FALSE)
			(theGame setCursor: 999 (HaveMouse))
			(ego illegalBits: 0 setMotion: MoveTo 244 80)
		)
;;;		(if (& (ego onControl: origin) cBLUE)
;;;			(ego illegalBits: cWHITE)
		(if (& (ego onControl: 1) $0002)
			(ego illegalBits: -32768)
						(User canControl: FALSE canInput: FALSE)

				
				(User mapKeyToDir: FALSE)
			(theGame setCursor: 997 (HaveMouse))
			(curRoom newRoom: 65)
		)
		(super doit:)
	)
	
	(method (dispose)
		(DisposeScript 214)
		(super dispose:)
	)
	
	(method (handleEvent event &tmp temp0)
			(cond
			(
				(and
					(== (event type?) evMOUSEBUTTON)
					(not (& (event modifiers?) emRIGHT_BUTTON))
				)

			(switch (event type:)
				(evMOUSEBUTTON
					(if
						(and
							(not (& (event modifiers:) emSHIFT))
							(User controls:)
							

						)
;;;						(ego setMotion: MoveTo (((ego x?) +1) ((ego y?) +1) ))
						(User prevDir: 0)
						(event claimed: 1)

					)
				)
			)


	
			(if (ClickedOnObj rat (event x?) (event y?)) 
					
					(event claimed: TRUE)
					(switch theCursor	
						(998
							(DoVerb {examine rat})
						)
						(995
							
							
							(= temp7
							(Print
								{Rata}
								#button {Matar} 1
								#button {Capturar} 2
;;;								{Rat}
;;;								#button {Kill} 1
;;;								#button {Capture} 2								
							)
							)

						(switch temp7
							(1
							    (DoVerb {kill rat})
							   
	
							)
							(2
								(DoVerb {capture rat})
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



			(if (ClickedOnPicView trapdoor (event x?) (event y?)) 
				(event claimed: TRUE)
					(switch theCursor	
						(998
							(DoVerb {examine trapdoor})
						)
						(995
									
							(= temp7
							(Print
;;;								{Trap}
;;;								#button {Open} 1
;;;								#button {Close} 2
								{Trampilla}
								#button {Abrir} 1
								#button {Cerrar} 2								
							)
							)

						(switch temp7
							(1
							    (DoVerb {Open trapdoor})
							   
	
							)
							(2
								(DoVerb {Close trapdoor})
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
		
		
		
				(if (ClickedInRect 213 319 145 176 event) ;dino
				(event claimed: TRUE)
					(switch theCursor	
						(998
							(DoVerb {examine dinosaur})
						)
						(else
							(event claimed: FALSE)
						)
										
					)
			)	
			
		
						(if (or (ClickedInRect 168 175 181 185 event) ;bones
								(ClickedInRect 185 193 180 185 event)
								(ClickedInRect 204 224 174 183 event)
							)
						(event claimed: TRUE)
						(switch theCursor	
							(998	
								(DoVerb {examine bone})
							)
							(else
								(event claimed: FALSE)
						)
										
					)
			)	
		
			)
			)
		
		(if (event claimed?) (return))
		(if (== (event type?) saidEvent)
			(cond 
				((Said '*/dinosaur')
					(Print 51 1)
				)
				((Said '*/bone')
					(Print 51 2)
				)
				((Said 'examine>')
					(cond 
						((Said '[<around,at][/room]')
							(Print 51 0)
						)
						((Said '/stair')
							(Print 51 3)
						)
						((Said '/boulder')
							(Print 51 4)
						)
					)
				)
				((Said 'open/trapdoor')
					(Print 51 5)
				)
				((Said 'close/trapdoor')
					(Print 51 6)
				)
				((Said 'climb/stair')
					(Print 51 7)
				)
			)
		)
	)
	
	(method (cue)
		(HandsOn)
;;;		(ego illegalBits: cWHITE)
		(ego illegalBits: -32768)
			(User canControl: TRUE canInput: TRUE)

				
				(User mapKeyToDir: TRUE)
			(theGame setCursor: 999 (HaveMouse))		

	)
	
	(method (newRoom n)
		(super newRoom: n)
	)
)

(instance tumble of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(Falling priority: 5 play:)
				(ego setCycle: EndLoop self)
			)
			(1
				(ego
					setLoop: 3
					setCycle: Forward
					xStep: 8
					yStep: 8
					setMotion: MoveTo 100 158 self
				)
			)
			(2
				(ego posn: 103 171 setLoop: 5 cel: 0 setCycle: EndLoop self)
				(ShakeScreen 5 5)
			)
			(3
				(= cIcon 49)
				(= deathLoop 5)
				(= deathCel 4)
				(EgoDead 51 8)
			)
		)
	)
)

(instance Scurry of Script

	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds (Random 3 5)))
			(1
				(rat setMotion: MoveTo -10 169 self)
				(ratNoise play:)
			)
			(2
				(rat dispose:)
				(client setScript: 0)
			)
		)
	)
)

(instance rat of Actor
	
	(method (handleEvent event)
		(cond 
			((Said '/mouse>')
				(cond 
					((Said 'examine')
						(if (rat mover?)
							(Print 51 9)
						else
							(DontSee)
						)
					)
					((Said 'get,capture')
						(if (rat mover?)
							(Print 51 10)
						else
							(DontSee)
						)
					)
					((Said 'kill')
						(if (rat mover?)
							(Print 51 11)
						else
							(DontSee)
						)
					)
				)
			)
			((and (rat mover?) (MousedOn self event shiftDown))
				(event claimed: TRUE)
				(Print 51 9)
			)
		)
	)
)

(instance Falling of Sound
	(properties
		number 70
	)
)

(instance ratNoise of Sound
	(properties
		number 58
	)
)

(instance trapdoor of RPicView
	(properties
		y 55
		x 239
		view 151
		priority 3
	)
	
	(method (handleEvent event)
		(if
			(or
				(MousedOn self event shiftDown)
				(Said 'examine/trapdoor')
				(Said 'examine<up')
			)
			(event claimed: TRUE)
			(Print 51 12)
		)
	)
)
