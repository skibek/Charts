TODO

db.getCollection('jobs-definition').find({})
db.getCollection('jobs-definition').find({}, { jobClass: 1, jobType: 1, name: 1 })
db.getCollection('account-name-masks').find({}).count()
db.getCollection('jobs-journal').find({processingDate: '2017.08.18', type: 'M_PRZETW_WYC_DEF'})
db.getCollection('jobs-journal').find({ type: /MPORT_PLIK_KOLEJ/})
 
 
db.getCollection('jobs-definition').find({bankId: 'BPS'})  
--28
 
db.getCollection('jobs-definition').find({bankId: 'BPS', active: true})
--25
 
db.getCollection('jobs-definition').find({bankId: 'BPS', active: true, jobStartType: 'AUTO'})
-- 8
 
 
db.getCollection('statements').find({'header.ddKliKntNrb':{$ne : ''} })
db.getCollection('statements').find({'active': true, 'type': 'DEF_BANK_MIESIECZNY'}).sort( { _id: -1 } ) - wywala się
db.getCollection('statements').find({'active': true, 'type': 'DEF_BANK_MIESIECZNY'})
db.getCollection('parameters').find({'value':/d:/})
db.getCollection('prepared-statements').find({'_id':ObjectId('5b488558e4b0c4cd02d389c4')})
 
 
db.getCollection('parameters').update({"_id" :ObjectId("wstawic_dla_banku") }, {$set : {"array.OUT_EMAIL_ATTACHMENT_PROWIZJA_FILE_NAME_TEMPLATE" : 'prowizja_data_count.pdf'} }  )
 
 
Rozmiar
db.getCollection('clients').find({ nrbList: { $size : 2 } } )
 
 
Distinct
db.getCollection('clients').distinct( "distributionChannelForStatements" )
