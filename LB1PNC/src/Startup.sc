;;; Sierra Script 1.0 - (do not remove this comment)
(script# 411) ;OK
(include game.sh)
(use Main)
(use Intrface)
(use Motion)
(use Game)
(use Menu)
(use Actor)
(use System)
(use User)

(public
	Startup 0
)

(instance Startup of Region
	
	(method (init)
		(super init:)
		(Load FONT 41)
		(Load rsVIEW 642)
		(LoadMany SOUND 29 94 95 96)
		(Load SCRIPT 406)
		(if (or possibleScore (not (Btst fSkippedIntro)))
			(ego loop: 2 posn: 211 109)
		else
			(TheMenuBar state: TRUE)
			(ego loop: 1 posn: 90 134)
			(gDoor setCycle: Walk setPri: 10 show:)
			(daddyBow setLoop: 2 setPri: 14 init: stopUpd: hide:)
			(suitCase setPri: 7 init:)
		)
		(self setScript: beginning)
	)
	
	(method (doit)
		(super doit:)
	)
	
	(method (dispose)
		(super dispose:)
	)
	
	(method (handleEvent event)
		(super handleEvent: event)
	)
)

(instance beginning of Script

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(User canControl: FALSE)
				(User canInput: FALSE)
				(cond 
					((not global216)
						(= state -1)
					)
					((self script?)
						(= state -1)
					)
					((== gameHours 6)
						(self setScript: (ScriptID 406 0))
						(= state -1)
					)
				)
				(= cycles 1)
			)
			(1
				(User canControl: FALSE canInput: FALSE)
				(if (or possibleScore (not (Btst fSkippedIntro)))
					(= possibleScore 0)
					(= state 10)
				else
					(Print 411 0)
					(= theTalker talkLILLIAN)
					(Say 1 411 1)
				)
				(= cycles 1)
			)
			(2
				(User canControl: FALSE canInput: FALSE)
				(gDoor setMotion: MoveTo -20 152 self)
				(ego loop: 2 stopUpd:)
			)
			(3
				(User canControl: FALSE canInput: FALSE)
				(= theTalker talkLAURA)
				(Say 0 411 2)
				(= cycles 1)
			)
			(4
				(User canControl: FALSE canInput: FALSE)
				(daddyBow
					show:
					cycleSpeed: 0
					moveSpeed: 0
					setCycle: Walk
					setMotion: MoveTo 108 78 self
				)
			)
			(5
				(= cycles 13)
			)
			(6
				(User canControl: FALSE canInput: FALSE)
				(daddyBow hide: dispose: delete:)
				(ego startUpd:)
				(= cycles 2)
			)
			(7
				(User canControl: FALSE canInput: FALSE)
				(= theTalker talkDADDY)
				(Say 1 411 3)
				(ego setMotion: MoveTo 211 109 self)
			)
			(8
				(User canControl: FALSE canInput: FALSE)
				(ego loop: 3)
				(suitCase cycleSpeed: 1 setCycle: EndLoop self)
			)
			(9
				(User canControl: FALSE canInput: FALSE)
				(Print 411 4)
				(suitCase setCycle: BegLoop self)
				
			)
			(10
				(User canControl: FALSE canInput: FALSE)
				(if (or (!= (gDoor x?) -20) (!= (ego loop?) 2))
					(ego loop: 2)
					(= state 9)
				else
					(suitCase dispose:)
				)
				(= cycles 1)
			)
			(11
				(User canControl: FALSE canInput: FALSE)
				(ego get: iNotebook)
				(++ global203)
				(= [global368 4] 1800)
				(HandsOn)
				(User canControl: TRUE)
				(User canInput: FALSE)
				(theGame setCursor: 999 (HaveMouse))
				(client setScript: 0)
			)
		)
	)
)

(instance suitCase of Prop
	(properties
		y 88
		x 208
		view 144
		loop 1
	)
)

(instance daddyBow of Actor
	(properties
		y 87
		x 96
		view 925
		signal ignrAct
		illegalBits $0000
	)
)
