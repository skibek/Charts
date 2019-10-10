# AWS

TOC
- [AWS services](#awsservices)
- [Helpers](#helpers)
- [Deploy info](#deploy_info)

## AWS services <a name="awsservices"></a>
```
Amazon Web Services
  Amazon S3 - Amazon Simple Storage Service  (Bucket = folder)
    https://en.wikipedia.org/wiki/Amazon_S3
    https://www.hostersi.pl/amazon-s3-bez-tajemnic/
    Amazon Glacier - archive
    
  EBS - Elastic Block Storage - disc for EC2 instance
  
  ELB (Elastic Load Balancer)

  AWS Elastic Beanstalk - PAAS - Platform As a service
	  Webserver env
	  Worker enc - long running actions
    
  SQS - Simple Queue Service
  
  Amazon CloudWatch - collect, monitor, act, analyse | events, alarms
  
  SNS

  RDS - have HA - Amazon Relational Database Service
  
  Amazon ElastiCache
  
  Sessions – redis i memcache

Security:
AWS Identity and Acces Managment – najważniejsza funkcja, pozwalająca na zarządzanie użytkownikami i prawami dostępu do AWS.
AWS Key Managment Service – do przechowywania kluczy do szyfrowania
AWS CloudTrail – logowanie wszystkiego, co dzieję się z kontem w Amazonie
AWS Web Application Firewall – pozwala tworzyć reguły do blokowania ataków na stronę / aplikację

AWS Account credentials;

– Multi-factor authentication software;
– Identity and Access Management features;
– Policies;
– API calls;
– Access to the AWS Management Console;
– S3 Server Side Encryption;
– Virtual Private Cloud (VPC);
– Tools to troubleshoot and optimize architecture and account data;
– Tools to configure server instances and make them operate efficiently.

https://d0.awsstatic.com/whitepapers/Security/AWS_Security_Best_Practices.pdf
```

## Helpers <a name="helpers"></a>

It's a best practice to maintain backups of your instances and data. Consider creating an AMI or creating snapshots of your EBS volumes before you change your infrastructure.

AWS Irlandia lub Frankfurt, znajdujące się na Europejskim Obszarze Gospodarczym (EOG).

### URLs
```
https://www.hostersi.pl/na-czym-wlasciwie-polega-wysoka-dostepnosc-ha-w-chmurze/
https://www.hostersi.pl/wysoka-dostepnosc-serwisu/
```

### Certificates
```
https://aws.amazon.com/blogs/apn/now-you-can-take-the-aws-certified-cloud-practitioner-exam-at-your-home-or-office-24-7/
https://www.aws.training/Details/Curriculum?id=27076
https://aws.amazon.com/training/path-cloudpractitioner/
https://aws.amazon.com/training/path-architecting/
```

### Infrastructure as a service IAAS

```
Terraform - by Hashicorp
Ansible
Puppet
Chef
CloudFormation - by AWS
```

URL:
```
https://devenv.pl/terraform-wprowadzenie/

```

## Deploy info <a name="deploy_info"></a>

```
Wdrażanie w chmurze:

CAMS (autor modelu John Willis), który mówi właśnie o tych czterech częściach: 
C – culture (kultura), 
A – automation (automatyzacja), 
M – measurement (metryki), 
S – sharing (współdzielenie)
```
